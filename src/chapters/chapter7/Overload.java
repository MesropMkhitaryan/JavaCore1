package chapters.chapter7;

public class Overload {
    void test() {
        System.out.println("there is not a single item");
    }
    void test(int a){
        System.out.println("a = " + a);
    }
    void test(int a, int b){
        System.out.print("a = " + a + "b = " + b);
        System.out.println();
    }
    double test(double a){
        return a*a;
    }
}
