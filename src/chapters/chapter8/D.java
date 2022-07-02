package chapters.chapter8;

public class D extends C{
    int i;

    D(int a, int b){
     super.i = a;
     i = b;

    }
    void show(){
        System.out.println("i from upper class " + super.i);
        System.out.println("i from lower class " + i);
    }
}
