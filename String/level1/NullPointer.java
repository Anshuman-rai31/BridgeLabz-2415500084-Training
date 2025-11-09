package string.level1;

public class NullPointer {
    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e);
        }
    }

    public static void main(String[] args) {

        handleException();
    }
}
