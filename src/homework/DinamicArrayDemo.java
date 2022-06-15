package homework;

public class DinamicArrayDemo {
    public static void main(String[] args) {
        DinamicArray dinamicArray = new DinamicArray();
        dinamicArray.add(4);
        dinamicArray.add(7);
        dinamicArray.add(15);
        dinamicArray.add(16);
        dinamicArray.add(62);
        dinamicArray.add(11);
        dinamicArray.add(78);
        dinamicArray.add(51);

        dinamicArray.set(6,18);
        System.out.println();
        System.out.println(dinamicArray.isEmpty());
        System.out.println(dinamicArray.getByIndex(1));
        System.out.println(dinamicArray.getFirstIndexByValue(15));
        dinamicArray.add(4,6);
        dinamicArray.printArray();

        System.out.println();
        dinamicArray.delete(1);
        dinamicArray.printArray();



    }

}
