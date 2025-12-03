import java.util.*;
public class FruitStorageDemo {
    static class Fruit {
        private String name;
        Fruit(String name){ this.name = name; }
        public String getName(){ return name; }
        public String toString(){ return name; }
    }
    static class Apple extends Fruit { Apple(){ super("Apple"); } }
    static class Mango extends Fruit { Mango(){ super("Mango"); } }
    static class FruitBox<T extends Fruit> {
        private List<T> items = new ArrayList<>();
        public void add(T item){ items.add(item); }
        public void display(){
            System.out.println("Fruits in box:");
            for(T f : items) System.out.println("- " + f);
        }
    }
    public static void main(String[] args){
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.display();
        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.add(new Mango());
        mangoBox.display();
    }
}

