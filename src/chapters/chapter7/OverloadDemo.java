package chapters.chapter7;

public class OverloadDemo {
    public static void main(String[] args) {
        Overload over = new Overload();
        double res;

        over.test();
        over.test(5);
        over.test(8,9);
        res = over.test(14.5);
        System.out.println(res);
    }
}
