import java.util.*;

public class DirectorySizeCalculator {

    static class FileSystemItem {
        String name;
        int size;
        boolean isFile;
        List<FileSystemItem> children;

        FileSystemItem(String name, int size) {
            this.name = name;
            this.size = size;
            this.isFile = true;
            this.children = new ArrayList<>();
        }

        FileSystemItem(String name) {
            this.name = name;
            this.size = 0;
            this.isFile = false;
            this.children = new ArrayList<>();
        }

        void addChild(FileSystemItem child) {
            this.children.add(child);
        }
    }

    public int calculateSizeRecursive(FileSystemItem item) {
        if (item.isFile) {
            return item.size;
        }
        int totalSize = 0;
        for (FileSystemItem child : item.children) {
            totalSize += calculateSizeRecursive(child);
        }
        return totalSize;
    }

    public int calculateSizeIterative(FileSystemItem root) {
        if (root.isFile) {
            return root.size;
        }
        int totalSize = 0;
        Stack<FileSystemItem> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            FileSystemItem current = stack.pop();
            if (current.isFile) {
                totalSize += current.size;
            } else {
                for (FileSystemItem child : current.children) {
                    stack.push(child);
                }
            }
        }
        return totalSize;
    }

    public int calculateSizeWithCycleDetection(FileSystemItem item, Set<FileSystemItem> visited) {
        if (visited.contains(item)) {
            System.out.println("  Cycle detected at: " + item.name + " - skipping");
            return 0;
        }
        visited.add(item);

        if (item.isFile) {
            return item.size;
        }
        int totalSize = 0;
        for (FileSystemItem child : item.children) {
            totalSize += calculateSizeWithCycleDetection(child, visited);
        }
        return totalSize;
    }

    public void traceExecution(FileSystemItem item, int depth) {
        String indent = "  ".repeat(depth);
        if (item.isFile) {
            System.out.println(indent + "CALL calculateSize(\"" + item.name + "\") -> BASE CASE: return " + item.size + " KB");
            return;
        }
        System.out.println(indent + "CALL calculateSize(\"" + item.name + "/\") -> RECURSIVE CASE");
        int total = 0;
        for (FileSystemItem child : item.children) {
            traceExecution(child, depth + 1);
            int childSize = calculateSizeRecursive(child);
            total += childSize;
            System.out.println(indent + "  Running total for \"" + item.name + "/\": " + total + " KB");
        }
        System.out.println(indent + "RETURN from \"" + item.name + "/\": " + total + " KB");
    }

    public static void main(String[] args) {
        DirectorySizeCalculator calculator = new DirectorySizeCalculator();

        FileSystemItem project = new FileSystemItem("project");

        FileSystemItem src = new FileSystemItem("src");
        src.addChild(new FileSystemItem("main.java", 100));
        src.addChild(new FileSystemItem("utils.java", 50));

        FileSystemItem docs = new FileSystemItem("docs");
        docs.addChild(new FileSystemItem("readme.txt", 10));
        FileSystemItem guides = new FileSystemItem("guides");
        guides.addChild(new FileSystemItem("setup.pdf", 200));
        docs.addChild(guides);

        project.addChild(src);
        project.addChild(docs);
        project.addChild(new FileSystemItem("config.xml", 20));

        System.out.println("=== Part (a) & (b): Recursive Calculation with Trace ===");
        System.out.println();
        calculator.traceExecution(project, 0);
        System.out.println();

        int recursiveSize = calculator.calculateSizeRecursive(project);
        System.out.println("Total size (recursive): " + recursiveSize + " KB");
        System.out.println();

        System.out.println("=== Part (c): Time Complexity ===");
        System.out.println("Time Complexity: O(N) where N = total number of files and directories");
        System.out.println("Each file/directory is visited exactly once");
        System.out.println("Space Complexity: O(D) where D = maximum depth of directory tree (call stack)");
        System.out.println();

        System.out.println("=== Part (d): Iterative Solution ===");
        int iterativeSize = calculator.calculateSizeIterative(project);
        System.out.println("Total size (iterative using Stack): " + iterativeSize + " KB");
        System.out.println("Iterative uses explicit Stack data structure");
        System.out.println("Both approaches have O(N) time complexity");
        System.out.println("Iterative avoids stack overflow for very deep directories");
        System.out.println();

        System.out.println("=== Part (e): Cycle Detection (Symbolic Links) ===");
        FileSystemItem cycleProject = new FileSystemItem("project");
        FileSystemItem cycleSrc = new FileSystemItem("src");
        cycleSrc.addChild(new FileSystemItem("main.java", 100));
        cycleSrc.addChild(cycleProject);
        cycleProject.addChild(cycleSrc);
        cycleProject.addChild(new FileSystemItem("config.xml", 20));

        Set<FileSystemItem> visited = new HashSet<>();
        int safeSize = calculator.calculateSizeWithCycleDetection(cycleProject, visited);
        System.out.println("Total size with cycle detection: " + safeSize + " KB");
        System.out.println("Without cycle detection, symbolic links cause infinite recursion (StackOverflowError)");
        System.out.println("Solution: Track visited nodes using a Set to detect and skip cycles");
    }
}
