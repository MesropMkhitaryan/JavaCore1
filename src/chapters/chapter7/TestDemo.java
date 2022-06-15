package chapters.chapter7;

public class TestDemo {
    public static void main(String[] args) {
        Test test = new Test(120,10);
        Test test1 = new Test(120,10);
        Test test2 = new Test(-1,-1);
        System.out.println(test.equalTo(test1));
        System.out.println(test.equalTo(test2));
    }
}
