package chapters.chapter7;

public class BoxNewDemo {
    public static void main(String[] args) {
        BoxNew boxNew = new BoxNew(1,5,6);
        BoxNew bo = new BoxNew(5);
        BoxNew bs = new BoxNew();
        double vol;
        vol = boxNew.volume();
        System.out.println(vol);
        vol = bo.volume();
        System.out.println(vol);
        vol = bs.volume();
        System.out.println(vol);
    }
}
