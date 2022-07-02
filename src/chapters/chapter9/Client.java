package chapters.chapter9;

public class Client implements Callback {
    @Override
    public void callback(int p) {

        System.out.println("method callback "+p);
    }
}
