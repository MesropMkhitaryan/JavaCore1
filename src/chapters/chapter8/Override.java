package chapters.chapter8;

public class Override extends Over{
    int k;
    Override(int j, int i, int q){
        super(j,i);
        k = q;
    }

    @java.lang.Override
    void appear() {
        System.out.println("k = " + k);
    }
}
