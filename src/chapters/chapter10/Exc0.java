package chapters.chapter10;

public class Exc0 {
    public static void main(String[] args) {
       try {
           int d =0;
           int a = 4/d;
           System.out.println(a);
       }
       catch (ArithmeticException exception){
           System.out.println("cant divide on 0");
       }
    }
}
