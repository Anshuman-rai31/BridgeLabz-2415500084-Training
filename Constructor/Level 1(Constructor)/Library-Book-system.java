public class Book {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.availability = true;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook() {
        availability = true;
        System.out.println("Book returned successfully");
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + availability);
    }

    public static void main(String[] args) {
        Book book = new Book("Effective Java", "Joshua Bloch", 699.0);
        book.displayDetails();
        book.borrowBook();
        book.displayDetails();
        book.returnBook();
        book.displayDetails();
    }
}
