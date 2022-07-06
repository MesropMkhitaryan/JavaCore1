package chapters.chapter10;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException{
        System.out.println("in body of method throwsOne");
        throw new IllegalAccessException();
    }

    public static void main(String[] args) {
        try {
            throwOne();
        }
        catch (IllegalAccessException e){
            System.out.println("exception is caught " + e);
        }
    }
}
