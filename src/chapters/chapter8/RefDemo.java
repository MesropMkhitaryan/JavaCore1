package chapters.chapter8;

public class RefDemo {
    public static void main(String[] args) {
        BoxWeight boxWeight = new BoxWeight(11,2,3,5);
        Box plainbox = new Box();
        double vol;

        vol = boxWeight.volume();
        System.out.println("weightbox volume = "+vol);
        System.out.println("weight = "+boxWeight.weight);
        System.out.println();

        plainbox = boxWeight;
        vol = plainbox.volume();
        System.out.println("plainbox volume = " + vol);


    }
}
