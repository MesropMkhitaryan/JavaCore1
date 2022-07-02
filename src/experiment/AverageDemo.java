package experiment;

import java.util.Scanner;

public class AverageDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("print first number");
        double num = scan.nextDouble();
        System.out.println("print second number");
        double num1 = scan.nextDouble();
        System.out.println("print third number");
        double num2 = scan.nextDouble();
        System.out.println(Average.avg(num, num1, num2));

    }
}
