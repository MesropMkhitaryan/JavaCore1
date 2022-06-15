package chapters.chapter7;

public class Overload1 {
    void test(){
        System.out.println("there is no item");
    }
    void test(int c, int d){
        System.out.println("a and b are equal " + c + " " + d);
    }
    void test(double c){
        System.out.println(c);
    }

}
