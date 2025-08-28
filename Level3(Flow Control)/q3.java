import java.util.Scanner;
class Q3_Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();
        double avg = (physics + chemistry + maths) / 3.0;
        System.out.println("Average = " + avg);
        if (avg >= 90) System.out.println("Grade A: Excellent");
        else if (avg >= 75) System.out.println("Grade B: Very Good");
        else if (avg >= 50) System.out.println("Grade C: Good");
        else System.out.println("Grade D: Needs Improvement");
        sc.close();
    }
}
