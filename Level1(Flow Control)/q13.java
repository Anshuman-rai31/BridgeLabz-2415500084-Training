import java.util.Scanner;

public class q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n >= 1) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for(int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Formula Sum = " + sumFormula);
            System.out.println("For Loop Sum = " + sumLoop);
            System.out.println("Both results same? " + (sumFormula == sumLoop));
        } else {
            System.out.println("Not a natural number");
        }
    }
}
