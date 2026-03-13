package stack;
import java.util.Stack;
import java.util.*;

public class ValidParanthesis {
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                
                if (stack.isEmpty()) {
                	return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(')||(ch == '}' && top != '{')||(ch == ']' && top != '[')) {
                	return false;
                }
            
                
               
            }
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expr = sc.nextLine();

        if (isValid(expr)) {
            System.out.println("Parentheses are Balanced");
        } else {
            System.out.println("Parentheses are NOT Balanced");
        }

        sc.close();
    
	}



}
