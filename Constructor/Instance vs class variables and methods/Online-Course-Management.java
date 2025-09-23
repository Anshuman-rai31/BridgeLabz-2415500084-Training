public class Course {
    private String courseName;
    private String duration;
    private double fee;
    private static String instituteName = "TechLearn Institute";

    public Course(String courseName, String duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", "6 Weeks", 15000.0);
        course1.displayCourseDetails();
        Course.updateInstituteName("Global Tech Academy");
        Course course2 = new Course("Python Basics", "4 Weeks", 10000.0);
        course2.displayCourseDetails();
    }
}
