import java.util.Scanner;
class Q4_PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean isPrime = num > 1;
        for (int i = 2; i <= num/2 && isPrime; i++) {
            if (num % i == 0) isPrime = false;
        }
        System.out.println(num + (isPrime ? " is Prime" : " is Not Prime"));
        sc.close();
    }
}
