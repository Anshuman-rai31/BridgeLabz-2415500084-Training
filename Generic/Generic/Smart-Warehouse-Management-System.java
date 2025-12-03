import java.util.*;
public class SmartWarehouseDemo {
    static abstract class WarehouseItem {
        private String id;
        WarehouseItem(String id){ this.id = id; }
        public String getId(){ return id; }
        public abstract String getType();
        public String toString(){ return getType() + ":" + id; }
    }
    static class Electronics extends WarehouseItem { Electronics(String id){ super(id); } public String getType(){ return "Electronics"; } }
    static class Groceries extends WarehouseItem { Groceries(String id){ super(id); } public String getType(){ return "Groceries"; } }
    static class Furniture extends WarehouseItem { Furniture(String id){ super(id); } public String getType(){ return "Furniture"; } }
    static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();
        public void add(T item){ items.add(item); }
        public List<T> getItems(){ return items; }
    }
    public static void displayAllItems(List<? extends WarehouseItem> items){
        System.out.println("Displaying stored items:");
        for(WarehouseItem w : items) System.out.println("- " + w);
    }
    public static void main(String[] args){
        Storage<Electronics> es = new Storage<>();
        es.add(new Electronics("E-001"));
        es.add(new Electronics("E-002"));
        Storage<Groceries> gs = new Storage<>();
        gs.add(new Groceries("G-101"));
        displayAllItems(es.getItems());
        displayAllItems(gs.getItems());
    }
}

