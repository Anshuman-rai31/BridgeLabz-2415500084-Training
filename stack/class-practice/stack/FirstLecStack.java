package stack;
import java.util.*;

public class FirstLecStack {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();

        int len;
        if (input.isEmpty()) {
            len = 10; 
        } else {
            len = Integer.parseInt(input);
            if (len < 1) {
                len = 10;
            }
        }
       
        int[] arr = new int[len];
        int count = 0;

        while (true) {
            int value = sc.nextInt();
            
            if (count >= len * 0.75) {
                int newLen = len + len / 2;   
                int[] newArr = new int[newLen];
                
                for (int i = 0; i < len; i++) {
                    newArr[i] = arr[i];
                }
                
                arr = newArr;  
                len = newLen;  
                System.out.println("Array resized to: " + len);
            }

            arr[count] = value;
            count++;
        }
    }
}