//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

import java.util.Scanner;
import java.util.Stack;
import static java.lang.System.*;

public class StackTest
{
	private Stack<String> stack;

	public StackTest()
	{
		setStack("");
	}

	public StackTest(String line)
	{
		setStack(line);
	}
	
	public void setStack(String line)
	{
		stack = new Stack<String>();
		Scanner in = new Scanner(line);
		while (in.hasNext()) {
			stack.push(in.next());

		}
	}

	public void popEmAll()
	{
		System.out.println("popping all items from the stack");
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println("\n\n");
	}

	//add a toString
	@Override
	public String toString() {
		return stack.toString() + "\n";		
	}
}