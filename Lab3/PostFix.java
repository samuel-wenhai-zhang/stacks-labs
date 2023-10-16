//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	public PostFix()
	{
		setExpression("");
	}

	public PostFix(String exp)
	{
		setExpression(exp);
	}

	public void setExpression(String exp)
	{
		stack = new Stack<Double>();
		expression = exp;
	}

	public double calc(double one, double two, char op)
	{
		if (op == '+') {
			return one + two;
		}
		else if (op == '-') {
			return one - two;
		}
		else if (op == '*') {
			return one * two;
		}
		else if (op == '/') {
			return one / two;
		}
		else {
			return 0;
		}
	}

	public void solve()
	{
		Scanner in = new Scanner(expression);
		while (in.hasNext()) {
			String value = in.next();
			try {
				stack.push(Double.parseDouble(value));
			}
			catch (NumberFormatException e) {
				double d2 = stack.pop();
				double d1 = stack.pop();
				stack.push(calc(d1, d2, value.charAt(0)));
			}
		}
	}

	@Override
	public String toString() {
		return expression + " = " + stack.peek();
	}

}