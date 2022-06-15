package homework;

public class DinamicArray {
    private int[] array = new int[8];
    private int size = 0;

    public void add(int value) {
        if (array.length == size) {
            extend();
        }
        array[size++] = value;
    }

    //Գրել մեթոդ isEmpty անունով, որը կվերադարձնի true եթե մեր dynamicArray-ի մեջ չունենանք ոչ մի էլեմենտ. Եթե ունենք՝ false
    //Գրել մեթոդ getByIndex անունով, որը կընդունի ինդեքս, և կվերադարձնի այդ ինդեքսի տակ ընկած թիվը, եթե չկա թող վերադարձնի 0;
    //Գրել մեթոդ getFirstIndexByValue, որը կընդունի int value, և եթե մեր մասիվի մեջ ունենք այդ թվից, կվերադարձնի իր ինդեքսը. եթե շատ ունենք, պետք է վերադարձնել առաջինի ինդեքսը
    //Գրել մեթոդ set անունով, որը կընդունի int index, int value և վալյուն կդնի տրված ինդեքսի տեղը(կփոխարինի էղած արժեքին).
    //Գրել մեթոդ add(int index, int value) որը տրված վելյուն կդնի տրված ինդեքսի տեղը, իսկ էղած թիվը ու կողքի բոլոր թվերը կտանի աջ, ոչ մի թիվ չի կորի
    //Գրել մեթոդ delete(int index) որ տանք ինդեքսը, այդ ինդեքսի տակ գտնվող թիվը հեռացնի մասիվից. (նոր մասիվ պետք չէ սարքել)
    public boolean isEmpty() {
            return array.length <= 0;
    }

    public int getByIndex(int index) {
        return array[index];
    }

    public int getFirstIndexByValue(int val) {
        for (int i = 0; i < array.length; i++) {
            if (val == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, int value) {
        array[index] = value;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
   void add(int index, int value){
        if (size == array.length){
            extend();
        }
       for (int i = size-1; i >= index; i--) {
           array[i+1] = array[i];
       }
       array[index] = value;
       size++;
   }


    void delete(int index) {
        if (index >= 0 || index < size) {

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }


    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
