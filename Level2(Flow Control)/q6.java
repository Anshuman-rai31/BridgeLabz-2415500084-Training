import java.util.Scanner;
public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age and height of Amar: ");
        int age1 = sc.nextInt(), h1 = sc.nextInt();
        System.out.print("Enter age and height of Akbar: ");
        int age2 = sc.nextInt(), h2 = sc.nextInt();
        System.out.print("Enter age and height of Anthony: ");
        int age3 = sc.nextInt(), h3 = sc.nextInt();
        if (age1 < age2 && age1 < age3) System.out.println("Youngest: Amar");
        else if (age2 < age3) System.out.println("Youngest: Akbar");
        else System.out.println("Youngest: Anthony");
        if (h1 > h2 && h1 > h3) System.out.println("Tallest: Amar");
        else if (h2 > h3) System.out.println("Tallest: Akbar");
        else System.out.println("Tallest: Anthony");
    }
}
