package wrapperclass;

public class ConversionDataTypes {
    public static void main(String[] args) {
        int primitive = 50;
        Integer wrapper = Integer.valueOf(primitive);
        String str = wrapper.toString();
        Integer backToInt = Integer.parseInt(str);

        System.out.println("int: " + primitive);
        System.out.println("Integer: " + wrapper);
        System.out.println("String: " + str);
        System.out.println("Back to Integer: " + backToInt);
    }
}
