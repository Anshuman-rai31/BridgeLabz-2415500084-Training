package stack;
import java.util.Stack;
public class DeleteConsecutiveWord {

	public static void main(String[] args) {
		Stack<String>st=new Stack<>();
		String arr[]={"ab","aa","aa","bad","ab"};
		for(String word:arr)
		{
			if(!st.empty() && st.peek()==word)
			{
				st.pop();
			}
			else
			{
				st.push(word);
			}
		}
		for(String word:st)
		{
			System.out.print(word+" ");
		}
	}

}
