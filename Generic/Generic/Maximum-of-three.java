public class GenericMaximumDemo {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max) > 0) max = y;
        if(z.compareTo(max) > 0) max = z;
        return max;
    }
    public static void main(String[] args){
        System.out.println("Max of 3,7,5 = " + maximum(3,7,5));
        System.out.println("Max of 2.3,4.5,1.2 = " + maximum(2.3,4.5,1.2));
        System.out.println("Max of A,C,B = " + maximum("A","C","B"));
    }
}

