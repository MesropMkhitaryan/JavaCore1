package chapters.chapter12;

public class EnumExample {
    public static void main(String[] args) {
        Apple apple = Apple.GoldenDel;
        if (apple == Apple.GoldenDel){
            System.out.println("apple is " + Apple.GoldenDel);
        }
    }
}
