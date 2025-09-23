public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int additionalQuantity) {
        quantity += additionalQuantity;
    }

    public void removeItem(int removalQuantity) {
        if (removalQuantity <= quantity) {
            quantity -= removalQuantity;
        } else {
            System.out.println("Cannot remove more than available");
        }
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 80000.0, 1);
        item.addItem(1);
        item.displayDetails();
    }
}
