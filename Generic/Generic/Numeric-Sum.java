import java.util.*;
public class NumericSumDemo {
    public static double sumNumbers(List<? extends Number> list){
        double sum = 0.0;
        for(Number n : list) sum += n.doubleValue();
        return sum;
    }
    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(10,20,30);
        List<Double> dbls = Arrays.asList(2.5,3.75,4.0);
        System.out.println("Sum integers = " + sumNumbers(ints));
        System.out.println("Sum doubles = " + sumNumbers(dbls));
    }
}

