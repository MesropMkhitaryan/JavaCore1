package chapters.chapter12;

public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap;

        System.out.println("price of goldenDel apple is " + Apple.GoldenDel.getPrice());

        for (Apple a : Apple.values()) {
            if (a.getPrice() > 0) {
                System.out.println(a + "price is " + a.getPrice());
            }
        }
    }
}
