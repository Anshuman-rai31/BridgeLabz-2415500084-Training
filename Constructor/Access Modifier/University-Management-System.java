class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double cgpa) {
        this.CGPA = cgpa;
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String researchTopic) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.setCGPA(cgpa);
        this.researchTopic = researchTopic;
    }

    public void displayPostgraduateDetails() {
        displayDetails();
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        PostgraduateStudent student = new PostgraduateStudent(101, "Alice", 3.8, "AI Research");
        student.displayPostgraduateDetails();
    }
}
