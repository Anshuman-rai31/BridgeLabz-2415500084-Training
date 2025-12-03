import java.util.*;
public class PriceCalculatorDemo {
    static class Product {
        private String name;
        private double price;
        Product(String name, double price){ this.name = name; this.price = price; }
        public double getPrice(){ return price; }
        public String toString(){ return name + ":" + price; }
    }
    static class Mobile extends Product { Mobile(String n,double p){ super(n,p); } }
    static class Laptop extends Product { Laptop(String n,double p){ super(n,p); } }
    public static double calculateTotal(List<? extends Product> items){
        double total = 0;
        for(Product p : items) total += p.getPrice();
        return total;
    }
    public static void main(String[] args){
        List<Mobile> mobiles = Arrays.asList(new Mobile("M1",15000), new Mobile("M2",12000));
        List<Laptop> laptops = Arrays.asList(new Laptop("L1",55000));
        System.out.println("Mobiles total = " + calculateTotal(mobiles));
        System.out.println("Laptops total = " + calculateTotal(laptops));
    }
}

