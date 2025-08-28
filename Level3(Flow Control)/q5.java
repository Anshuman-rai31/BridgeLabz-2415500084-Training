import java.util.Scanner;
class Q5_Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0, orig = number;
        while (number != 0) {
            int d = number % 10;
            sum += d*d*d;
            number /= 10;
        }
        if (sum == orig) System.out.println(orig + " is Armstrong");
        else System.out.println(orig + " is Not Armstrong");
        sc.close();
    }
}
