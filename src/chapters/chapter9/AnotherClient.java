package chapters.chapter9;

public class AnotherClient implements Callback{
    @Override
    public void callback(int p) {
        System.out.println("another callback method ");
        System.out.println("p in square = " + (p*p));
    }
}