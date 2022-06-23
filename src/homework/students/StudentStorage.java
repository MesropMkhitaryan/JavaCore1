package homework.students;
public class StudentStorage {
    private Student[] array = new Student[10];
    private int size = 0;

    public void add(Student student) {
        if (array.length == size) {
            extend();
        }
        array[size++] = student;
    }
    public boolean isEmpty() {
            return array.length <= 0;
    }
    void delete(int index) {
        if (index >= 0 && index < size) {

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
        else {
            System.out.println("index out of bounds");
        }
    }
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + "." +array[i] + " ");
        }
    }
    private void extend() {
        Student[] temp = new Student[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
    public int getSize(){
        return size;
    }

    public void printStudentsByLesson(String lessonName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getLesson().equals(lessonName)){
                System.out.println(array[i]);
            }

        }
    }


    public void changeStudentsLesson(int newLesInd, String newLesson) {
        for (int i = 0; i <size ; i++) {
            if (i == newLesInd){
                array[i].setLesson(newLesson);
            }
        }
    }
}