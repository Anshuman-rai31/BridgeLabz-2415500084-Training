import java.util.Scanner;

public class q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n >= 0) {
            int fact = 1, i = 1;
            while(i <= n) {
                fact *= i;
                i++;
            }
            System.out.println("Factorial = " + fact);
        } else {
            System.out.println("Enter a positive integer");
        }
    }
}
