public class GenericBoxDemo {
    static class Box<T> {
        private T value;
        public void set(T value){ this.value = value; }
        public T get(){ return value; }
    }
    public static void main(String[] args){
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        Box<Double> dblBox = new Box<>();
        dblBox.set(45.67);
        System.out.println("Integer in box: " + intBox.get());
        System.out.println("String in box: " + strBox.get());
        System.out.println("Double in box: " + dblBox.get());
    }
}

