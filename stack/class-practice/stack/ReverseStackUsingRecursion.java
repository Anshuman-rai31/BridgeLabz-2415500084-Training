package stack;
import java.util.Stack;

public class ReverseStackUsingRecursion {
	
	public static void reverse(Stack<Integer> stack) {
		
		if(stack.isEmpty()) {
			return;
		}
		
		int up=stack.pop();
		reverse(stack);
		insertatbottom(stack,up);
		
		
	}
	
	public static void insertatbottom(Stack<Integer> stack,int x) {
		if(stack.isEmpty()) {
			stack.push(x);
			return;
		}
		int up=stack.pop();
		insertatbottom(stack,x);
		stack.push(up);
	}
	
	public static void insertsort(Stack<Integer> stack,int x) {
		if(stack.isEmpty() || stack.peek()<= x) {
			stack.push(x);
			return;
		}
		int up=stack.pop();
		insertsort(stack,x);
		stack.push(up);
	}
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(6);
		reverse(stack);
		System.out.println(stack);
	}

}
