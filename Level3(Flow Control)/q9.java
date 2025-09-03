import java.util.Scanner;
class Q9_Abundant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        if (sum > num) System.out.println(num + " is Abundant Number");
        else System.out.println(num + " is Not Abundant Number");
        sc.close();
    }
}
