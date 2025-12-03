import java.util.*;
public class CourseManagementDemo {
    static abstract class CourseType {
        private String title;
        CourseType(String title){ this.title = title; }
        public String getTitle(){ return title; }
    }
    static class ExamCourse extends CourseType { ExamCourse(String t){ super(t); } }
    static class AssignmentCourse extends CourseType { AssignmentCourse(String t){ super(t); } }
    static class ResearchCourse extends CourseType { ResearchCourse(String t){ super(t); } }
    static class Course<T extends CourseType> {
        private String code;
        private T type;
        Course(String code, T type){ this.code = code; this.type = type; }
        public String toString(){ return code + " - " + type.getTitle() + " (" + type.getClass().getSimpleName() + ")"; }
    }
    public static void printAnyCourses(List<? extends CourseType> types){
        for(CourseType t : types) System.out.println(t.getTitle() + " [" + t.getClass().getSimpleName() + "]");
    }
    public static void main(String[] args){
        Course<ExamCourse> c1 = new Course<>("CSE101", new ExamCourse("Algorithms"));
        Course<AssignmentCourse> c2 = new Course<>("CSE102", new AssignmentCourse("Web Project"));
        System.out.println(c1);
        System.out.println(c2);
        List<CourseType> allTypes = Arrays.asList(new ExamCourse("Algorithms"), new ResearchCourse("Thesis"));
        printAnyCourses(allTypes);
    }
}

