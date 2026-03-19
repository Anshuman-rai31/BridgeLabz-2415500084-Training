package stack;
import java.util.Stack;

public class PostfixEvaluation {
	
	public static int post(String exp) {
		 Stack<Integer> stack = new Stack<>();

	     for (int i = 0; i < exp.length(); i++) {
	    	 char c = exp.charAt(i);
	    	 if (Character.isDigit(c)) {
	    		 stack.push(c - '0');
	    		 }
	    	 else {
	    		 int val2 = stack.pop();
	             int val1 = stack.pop();
	             
	             switch(c) {
	             case '+': stack.push(val1 + val2); break;
                 case '-': stack.push(val1 - val2); break;
                 case '*': stack.push(val1 * val2); break;
                 case '/': stack.push(val1 / val2); break;

	             }


	    	 }
	     }
	     return stack.peek();


	}
	
	public static void main(String[] args) {
		String exp="23*54*+9-";
		System.out.print(post(exp));
	}

}
