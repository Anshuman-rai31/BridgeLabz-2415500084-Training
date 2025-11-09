package string.level1;

import java.util.Scanner;

public class ToLowercase {
    static String toLowerManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
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

        String customLower = toLowerManual(text);
        String builtInLower = text.toLowerCase();

        boolean result = compareStringsCharAt(customLower, builtInLower);

        System.out.println("Custom lowercase: " + customLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Both are same? " + result);
    }
}
