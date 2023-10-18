package Lab5;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InToPost {
    private static Map<String, Integer> precendence = Map.of(
        "+", 1,
        "-", 1,
        "*", 2,
        "/", 2
    );

    private String infix;
    
    public InToPost(String infix) {
        this.infix = infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String convert() {
        Stack<String> operators = new Stack<String>();
        Scanner in = new Scanner(infix);
        String postfix = "";
        while (in.hasNext()) {
            String scanned = in.next();
            if (scanned.equals(")")) {
                while (!operators.peek().equals("(")) {
                    postfix += operators.pop() + " ";
                }
                operators.pop();
            }
            else if (scanned.equals("(")) {
                operators.push(scanned);
            }
            else if (!precendence.containsKey(scanned)) {
                postfix += scanned + " ";
            }
            else {
                if (operators.empty() || operators.peek().equals("(") || precendence.get(scanned) > precendence.get(operators.peek())) {
                    operators.push(scanned);
                }
                else {
                    while (!operators.empty() && !operators.peek().equals("(") && precendence.get(operators.peek()) >= precendence.get(scanned) ) {
                        postfix += operators.pop() + " ";
                    }
                    operators.push(scanned);
                }
            }
        }
        while (!operators.empty()) {
            postfix += operators.pop() + " ";
        }
        return postfix;
    }
}