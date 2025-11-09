package wrapperclass;

public class NumberFromat {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("12AB");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        }
    }
}
