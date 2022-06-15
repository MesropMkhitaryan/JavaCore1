package chapters.chapter7;

public class BoxNew {
    double width;
    double heigth;
    double depth;

    BoxNew(double w, double h, double d) {
        width = w;
        heigth = h;
        depth = d;
    }

    BoxNew() {
        width = -1;
        heigth = -1;
        depth = -1;
    }

    BoxNew(double len) {
        width = depth = heigth = len;
    }
    double volume(){
        return width*heigth*depth;
    }
}
