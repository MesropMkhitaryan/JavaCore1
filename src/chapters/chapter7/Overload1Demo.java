package chapters.chapter7;

public class Overload1Demo {
    public static void main(String[] args) {
     Overload1 ob = new Overload1();
     int i = 88;
     ob.test();
     ob.test(10,16);
     ob.test(i);
     ob.test(155.22);


    }
}
