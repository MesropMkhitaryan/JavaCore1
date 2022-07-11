package chapters.chapter12;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        Apple[] values = Apple.values();
        for (Apple a : values) {
            System.out.println(a);
        }
        System.out.println();

        ap = Apple.valueOf("Winesap");

    }
}
