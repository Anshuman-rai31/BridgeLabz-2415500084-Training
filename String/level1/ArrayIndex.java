package string.level1;

import java.util.Scanner;

public class ArrayIndex {
    static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        System.out.println("Enter 3 names:");
        for (int i = 0; i < 3; i++) {
            names[i] = sc.next();
        }


        handleException(names);
    }
}
