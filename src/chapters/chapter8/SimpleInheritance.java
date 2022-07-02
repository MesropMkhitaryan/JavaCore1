package chapters.chapter8;
public class SimpleInheritance {
    public static void main(String[] args) {
        A superOb = new A();
        A pol = new B();
        B subOb = new B();
        superOb.i=10;
        superOb.j=20;
        superOb.showij();

        System.out.println();

        subOb.i = 15;
        subOb.j = 25;
        subOb.k = 35;
        subOb.showk();
        subOb.sum();


        pol.i = 10;
        pol.j = 20;

    }
}