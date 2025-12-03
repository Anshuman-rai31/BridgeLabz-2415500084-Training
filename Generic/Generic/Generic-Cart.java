import java.util.*;
public class GenericCartDemo {
    static class Electronics {
        private String name;
        Electronics(String name){ this.name = name; }
        public String toString(){ return "Electronics:" + name; }
    }
    static class Clothing {
        private String name;
        Clothing(String name){ this.name = name; }
        public String toString(){ return "Clothing:" + name; }
    }
    static class Cart<T> {
        private List<T> items = new ArrayList<>();
        public void addItem(T item){ items.add(item); }
        public void removeItem(T item){ items.remove(item); }
        public void displayItems(){
            System.out.println("Cart items:");
            for(T i : items) System.out.println("- " + i);
        }
    }
    public static void main(String[] args){
        Cart<Electronics> eCart = new Cart<>();
        eCart.addItem(new Electronics("Phone"));
        eCart.addItem(new Electronics("Headphones"));
        eCart.displayItems();
        Cart<Clothing> cCart = new Cart<>();
        cCart.addItem(new Clothing("T-Shirt"));
        cCart.displayItems();
    }
}

