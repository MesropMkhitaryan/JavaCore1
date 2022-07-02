package chapters.chapter9;

public class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();

        c.callback(16);
        c= ob;
        c.callback(5);
    }
}
