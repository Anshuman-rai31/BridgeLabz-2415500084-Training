public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Unknown";
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25, "New York");
        Person person2 = new Person(person1);
        person1.displayDetails();
        person2.displayDetails();
    }
}
