package CollectionDemo;

import java.util.Stack;
import java.util.Vector;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());//Õ»Îª¿Õ£¬»á±¨´í
	}
}
