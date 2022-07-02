package homework.brace;

public class Stack {
    int stck[] = new int[20];
    int index;

    Stack(){
        index = -1;
    }

    void push(int item){
        if (index == 19){
            System.out.println("stack is full");
        }
        else {
            stck[++index] = item;
        }

    }
    int closeChar() {
        return stck[index];
    }
    void ignoreIt(){
        System.out.print("");


    }
    int pop(){
        if (index<0){
            return 0;
        }
        else {
            return stck[index--];
        }


    }
    void error(int lastBrace){
        System.out.println("error at index " + lastBrace);

    }
    boolean isNotEmpty() {
        return index != -1;
    }
}
