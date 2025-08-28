import java.util.Scanner;
class Q8_Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0, temp = num;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (num % sum == 0) System.out.println(num + " is Harshad Number");
        else System.out.println(num + " is Not Harshad Number");
        sc.close();
    }
}
