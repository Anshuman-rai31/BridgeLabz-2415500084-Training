import java.util.*;
public class DynamicMarketplaceDemo {
    static class BookCategory {}
    static class ClothingCategory {}
    static class GadgetCategory {}
    static class Product<C> {
        private String name;
        private double price;
        private C category;
        public Product(String name, double price, C category){ this.name = name; this.price = price; this.category = category; }
        public double getPrice(){ return price; }
        public void setPrice(double price){ this.price = price; }
        public String toString(){ return name + ":" + price; }
    }
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double newPrice = product.getPrice() * (1 - percentage/100.0);
        product.setPrice(newPrice);
    }
    public static void main(String[] args){
        Product<BookCategory> b = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> c = new Product<>("Jeans", 1200, new ClothingCategory());
        Product<GadgetCategory> g = new Product<>("Earbuds", 2500, new GadgetCategory());
        List<Product<?>> catalog = Arrays.asList(b,c,g);
        System.out.println("Catalog before discount: " + catalog);
        applyDiscount(b, 10);
        applyDiscount(g, 20);
        System.out.println("Catalog after discount: " + catalog);
    }
}

