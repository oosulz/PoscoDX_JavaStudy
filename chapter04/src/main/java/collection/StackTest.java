package collection;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("둘리");
		stack.push("마이콜");
		stack.push("또치");
		
		while(!stack.empty()) {
			String string = stack.pop();
			System.out.println(string);
		}
		
		// 비어있는 경우 예외 발생
		// stack.pop();
		
		stack.push("둘리");
		stack.push("마이콜");
		stack.push("또치");
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());		
	}

}
