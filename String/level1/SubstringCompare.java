package string.level1;

import java.util.Scanner;

public class SubstringCompare {
    static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < text.length(); i++) {
            result += text.charAt(i);
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
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userSubstring = createSubstring(text, start, end);
        String builtInSubstring = text.substring(start, end);

        boolean result = compareStringsCharAt(userSubstring, builtInSubstring);

        System.out.println("Custom substring: " + userSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Both substrings are same? " + result);
    }
}
