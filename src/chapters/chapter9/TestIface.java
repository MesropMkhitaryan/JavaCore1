package chapters.chapter9;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class TestIface {
    public static void main(String[] args) {
        Callback c = new Client();
        c.callback(6);
        System.out.println(c.NAME);
    }
}
