package chapters.chapter12;

public enum Apple {
    Jonathan,
    GoldenDel(15),
    RedDel(56),
    Winesap(14),
    Cortland(19);
    private int price;
    Apple(int p){
        price = p;
    }
    Apple(){

    }

     int getPrice() {
        return price;
    }
}
