import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt(), day = sc.nextInt();

        if((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}
