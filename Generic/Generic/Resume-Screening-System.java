import java.util.*;
public class ResumeScreeningDemo {
    static abstract class JobRole { private String title; JobRole(String t){ this.title = t; } public String getTitle(){ return title; } }
    static class SoftwareEngineer extends JobRole { SoftwareEngineer(){ super("Software Engineer"); } }
    static class DataScientist extends JobRole { DataScientist(){ super("Data Scientist"); } }
    static class ProductManager extends JobRole { ProductManager(){ super("Product Manager"); } }
    static class Resume<T extends JobRole> {
        private String candidate;
        private T role;
        public Resume(String candidate, T role){ this.candidate = candidate; this.role = role; }
        public String toString(){ return candidate + " -> " + role.getTitle(); }
    }
    public static void processResumes(List<? extends Resume<? extends JobRole>> list){
        for(Resume<? extends JobRole> r : list) System.out.println("Processing: " + r);
    }
    public static void main(String[] args){
        Resume<SoftwareEngineer> r1 = new Resume<>("Asha", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Ravi", new DataScientist());
        List<Resume<? extends JobRole>> batch = Arrays.asList(r1, r2);
        processResumes(batch);
    }
}

