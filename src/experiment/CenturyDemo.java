package experiment;

import java.util.Scanner;

public class CenturyDemo {
    public static void main(String[] args) {
        Century century = new Century();
        System.out.println("print age");
        Scanner scan = new Scanner(System.in);
        int age = scan.nextInt();
        System.out.println(century.giveAgeBackCentury(age));
    }
}
