package string.level1;

import java.util.Scanner;

public class ToUppercase {
    static String toUpperManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }
            result += c;
        }
        return result;
    }

    static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customUpper = toUpperManual(text);
        String builtInUpper = text.toUpperCase();

        boolean result = compareStringsCharAt(customUpper, builtInUpper);

        System.out.println("Custom uppercase: " + customUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Both are same? " + result);
    }
}
