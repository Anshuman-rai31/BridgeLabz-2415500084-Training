public class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is palindrome: " + isPalindrome());
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("A man a plan a canal Panama");
        checker.displayResult();
    }
}
