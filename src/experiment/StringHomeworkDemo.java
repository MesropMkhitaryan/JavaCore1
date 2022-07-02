package experiment;

import java.util.Scanner;
public class StringHomeworkDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("print text");
        String str = scan.nextLine();
        System.out.println(StringHomework.wordCounter(str));
    }
}