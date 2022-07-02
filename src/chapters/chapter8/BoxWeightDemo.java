package chapters.chapter8;

public class BoxWeightDemo {
    public static void main(String[] args) {
        BoxWeight mybox1 = new BoxWeight(5,7,8,6);
        BoxWeight mybox2 = new BoxWeight(2,3,4,5);
        double vol;

        vol = mybox1.volume();
        System.out.println("volume of mybox1 = " + vol);
        System.out.println("weight of mybox1 = " + mybox1.weight);

        vol = mybox2.volume();
        System.out.println("volume of mybox2 = " + vol);
        System.out.println("weight of mybox2 = " + mybox2.weight);
    }
}
