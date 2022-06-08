package homework;



public class BraceChecker {
    Stack stack = new Stack();
    private int braceArrayIndex;
    private final String text;
    int firstBrace;
    int lastBrace;


    BraceChecker(String text) {
        this.text = text;
    }

    void check() {


        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != '}' && c != '{' && c != ')' && c != '(' && c != ']' && c != '[' ){
                stack.ignoreIt();

            }
            switch (c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isNotEmpty()) {
                        lastBrace = stack.closeChar();
                        if (lastBrace == '(') {
                            stack.pop();

                        }
                        else {
                            System.out.println("error at index " + i);
                            return;
                        }
                    }
                    break;
                    case ']':
                    if (stack.isNotEmpty()) {
                        lastBrace = stack.closeChar();
                        if (lastBrace == '[') {
                            stack.pop();

                        }
                        else {
                            System.out.println("error at index " + i);
                            return;
                        }
                    }
                    break;
                    case '}':
                    if (stack.isNotEmpty()) {
                        lastBrace = stack.closeChar();
                        if (lastBrace == '{') {
                            stack.pop();

                        }
                        else {
                            System.out.println("error at index " + i);
                            return;
                        }
                    }
                    break;
            }
        }

    }

}
