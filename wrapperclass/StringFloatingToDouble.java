package wrapperclass;

public class StringFloatingToDouble {
    public static void main(String[] args) {
        String str = "45.67";
        Double d = Double.parseDouble(str);
        System.out.println("Integer value: " + d.intValue()); // 45
    }
}
