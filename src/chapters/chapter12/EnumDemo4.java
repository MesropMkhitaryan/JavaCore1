package chapters.chapter12;

public class EnumDemo4 {
    public static void main(String[] args) {
        Apple ap, ap1,ap2;
        for (Apple a : Apple.values()) {
            System.out.println(a + "order of enum is " + a.ordinal());
        }
        ap = Apple.GoldenDel;
        ap1 = Apple.Winesap;


    }
}
