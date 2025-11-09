package wrapperclass;

import java.util.Scanner;

public class NumericString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a numeric string: ");
        String input = sc.nextLine();

        int number = Integer.parseInt(input);
        int square = number * number;

        System.out.println("Square of " + number + " is: " + square);
    }
}
