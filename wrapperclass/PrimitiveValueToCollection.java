package wrapperclass;

import java.util.ArrayList;

public class PrimitiveValueToCollection {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Autoboxing automatically converts int → Integer
        list.add(5); // works fine (Java converts 5 -> Integer.valueOf(5))

        //If autoboxing didn’t exist,we need to write manually list.add(Integer.valueOf(5));

        System.out.println(list);
    }
}
