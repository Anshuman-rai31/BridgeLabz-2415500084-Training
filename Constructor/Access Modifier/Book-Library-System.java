class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private String format;

    public EBook(String isbn, String title, String author, String format) {
        this.ISBN = isbn;
        this.title = title;
        this.setAuthor(author);
        this.format = format;
    }

    public void displayEBookDetails() {
        displayBookDetails();
        System.out.println("Format: " + format);
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-0123456789", "Java Programming", "John Doe", "PDF");
        ebook.displayEBookDetails();
    }
}
