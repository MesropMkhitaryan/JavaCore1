package chapters.chapter7;

public class StaticByName {
    static int a = 42;
    static int b = 99;
    static void callme(){
        System.out.println("a = " + a);
    }


}
class StaticByNameDemo{
    public static void main(String[] args) {
        StaticByName.callme();
        System.out.println("b = " + StaticByName.b);
    }
}

