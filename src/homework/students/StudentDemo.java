package homework.students;
import java.util.Scanner;
public class StudentDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();
    public static void main(String[] args) {
        boolean run = true;
        while (run){
            System.out.println("input 0 for exit");
            System.out.println("input 1 to add student");
            System.out.println("input 2 to print student");
            System.out.println("input 3 to print student number");
            System.out.println("input 4 to delete student by index");
            System.out.println("input 5 to print student by lesson");
            System.out.println("input 6 to change student's lesson");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command){
                case 0:
                    run = false;
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentStorage.printArray();
                    break;
                case 3:
                    System.out.println(studentStorage.getSize());
                    break;
                case 4:
                    studentStorage.printArray();
                    System.out.println("please choose student index");
                    int index = Integer.parseInt(scanner.nextLine());
                    studentStorage.delete(index);
                    break;
                case 5:
                    System.out.println("please input lesson name");
                    String lessonName = scanner.nextLine();
                    studentStorage.printStudentsByLesson(lessonName);
                    break;
                case 6:
                    System.out.println("please input student index to change lesson");
                    String newLessonIndex = scanner.nextLine();
                    int newLesInd = Integer.parseInt(newLessonIndex);
                    System.out.println("please input new lesson name");
                    String newLesson = scanner.nextLine();
                    studentStorage.changeStudentsLesson(newLesInd,newLesson);
                    break;
                default:
                    System.out.println("invalid number please try again");

            }

        }


    }
    private static void addStudent(){
        System.out.println("Please input student name");
        String name = scanner.nextLine();
        System.out.println("Please input student surname");
        String surname = scanner.nextLine();
        System.out.println("Please input student age");
        String ageStr =  scanner.nextLine();
        System.out.println("Please input student phoneNumber");
        String phoneNumber =  scanner.nextLine();
        System.out.println("Please input student city");
        String place =  scanner.nextLine();
        System.out.println("Please input student lesson");
        String lesson =  scanner.nextLine();


        int age = Integer.parseInt(ageStr);
        Student student = new Student(name,surname,age,phoneNumber,place,lesson);
        studentStorage.add(student);
        System.out.println("thank you, student added");
    }
}