package chapters.chapter7;

public class RecTest {
    int values[];
    RecTest(int i){
        values = new int[i];
    }
    void printArray(int i){
        if (i == 0){
            return;
        }
        else {
            printArray(i-1);
        }
        System.out.println("[" + (i-1) + "] " + values[i-1]);
    }
}
class Recousrsion1{
    public static void main(String[] args) {
        RecTest rec = new RecTest(10);
        int i;

        for (i = 0; i < 10; i++) {
            rec.values[i] = i;

        }
        rec.printArray(10);

    }
}
