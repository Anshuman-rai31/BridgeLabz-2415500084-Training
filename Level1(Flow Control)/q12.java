import java.util.Scanner;

public class q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n >= 1) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0, i = 1;
            while(i <= n) {
                sumLoop += i;
                i++;
            }
            System.out.println("Formula Sum = " + sumFormula);
            System.out.println("While Loop Sum = " + sumLoop);
            System.out.println("Both results same? " + (sumFormula == sumLoop));
        } else {
            System.out.println("Not a natural number");
        }
    }
}
