package stack;

//public class NextGreat {
//    public static void main(String args[])
//    {
//        int arr[] = {1,3,2,4};
//        int a[] = {-1,-1,-1,-1};
//
//        for(int i = 0; i < arr.length; i++)
//        {
//            for(int j = i + 1; j < arr.length; j++)
//            {
//                if(arr[j] > arr[i])
//                {
//                    a[i] = arr[j];
//                    break;
//                }
//            }
//        }
//
//        for(int i = 0; i < a.length; i++)
//        {
//            System.out.print(a[i] + " ");
//        }
//    }
//
import java.util.Stack;

public class NextGreat {

    public static void main(String args[])
    {
        int arr[] = {1,3,2,4};
        int res[] = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < arr.length; i++)
        {
            while(!stack.isEmpty() && stack.peek() >= arr[i])  //for smallest stack.peek()>=arr[i]
            {
                stack.pop();
            }

            if(stack.isEmpty())
                res[i] = -1;
            else
                res[i] = stack.peek();

            stack.push(arr[i]);
        }

        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
    }
}