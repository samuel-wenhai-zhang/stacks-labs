//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Stack;
import static java.lang.System.*;

public class SyntaxChecker
{
	private String exp;
	private Stack<Character> symbols;

	public SyntaxChecker()
	{
		setExpression("");
	}

	public SyntaxChecker(String s)
	{
		setExpression(s);
	}
	
	public void setExpression(String s)
	{
		exp = s;
		symbols = new Stack<Character>();
	}

	public boolean checkExpression()
	{
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if ("{(<[".contains(Character.toString(c))) {
				symbols.push(c);
			}
			else if ("})>]".contains(Character.toString(c))) {
				if (!symbols.empty()) {
					char c2 = symbols.pop();
					if (c == '}' || c == '>' || c == ']') {
						if (c2 != c - 2) {
							return false;
						}
					}
					else {
						if (c2 != c - 1) {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}
		}
		return symbols.empty();
	}

	@Override
	public String toString() {
		if (checkExpression()) {
			return exp + " is correct.\n";
		}
		else {
			return exp + " is incorrect.\n";
		}
	}
}