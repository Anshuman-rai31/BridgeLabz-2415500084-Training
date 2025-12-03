import java.util.*;
public class CopyListDemo {
    public static void copyList(List<? super Number> dest, List<? extends Number> src){
        for(Number n : src) dest.add(n);
    }
    public static void main(String[] args){
        List<Integer> src = Arrays.asList(1,2,3);
        List<Number> dest = new ArrayList<>();
        copyList(dest, src);
        System.out.println("Destination after copy: " + dest);
        List<Double> src2 = Arrays.asList(2.5,3.5);
        copyList(dest, src2);
        System.out.println("Destination after second copy: " + dest);
    }
}

