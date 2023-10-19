package Lab5;

import java.util.Scanner;

public class InToPostRunner {
    public static void main(String[] args) {
        InToPost converter = new InToPost("");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an infix expression to be converted into postfix ('quit' to exit): ");
            String input = in.nextLine();
            if (input.equals("quit")) {
                break;
            }
            else {
                converter.setInfix(input);
                System.out.println(converter.convert());
            }
        }
    }
}
