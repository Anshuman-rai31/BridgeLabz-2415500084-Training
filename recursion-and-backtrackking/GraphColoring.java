import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

    private int vertices;
    private int[][] adjacencyMatrix;

    public GraphColoring(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjacencyMatrix[u][v] = 1;
        adjacencyMatrix[v][u] = 1;
    }

    public boolean solveColoring(int numColors) {
        int[] colors = new int[vertices];
        if (solve(colors, 0, numColors)) {
            printSolution(colors, numColors);
            return true;
        }
        System.out.println("No solution exists with " + numColors + " colors.");
        return false;
    }

    private boolean solve(int[] colors, int vertex, int numColors) {
        if (vertex == vertices) {
            return true;
        }

        for (int c = 1; c <= numColors; c++) {
            if (isSafe(vertex, colors, c)) {
                colors[vertex] = c;
                if (solve(colors, vertex + 1, numColors)) {
                    return true;
                }
                colors[vertex] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int vertex, int[] colors, int color) {
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    public int findChromaticNumber() {
        for (int numColors = 1; numColors <= vertices; numColors++) {
            int[] colors = new int[vertices];
            if (solve(colors, 0, numColors)) {
                return numColors;
            }
        }
        return vertices;
    }

    public List<int[]> findAllColorings(int numColors) {
        List<int[]> allSolutions = new ArrayList<>();
        int[] colors = new int[vertices];
        findAll(colors, 0, numColors, allSolutions);
        return allSolutions;
    }

    private void findAll(int[] colors, int vertex, int numColors, List<int[]> allSolutions) {
        if (vertex == vertices) {
            allSolutions.add(colors.clone());
            return;
        }

        for (int c = 1; c <= numColors; c++) {
            if (isSafe(vertex, colors, c)) {
                colors[vertex] = c;
                findAll(colors, vertex + 1, numColors, allSolutions);
                colors[vertex] = 0;
            }
        }
    }

    private void printSolution(int[] colors, int numColors) {
        String[] colorNames = {"", "Red", "Green", "Blue", "Yellow", "Orange", "Purple"};
        System.out.println("Solution with " + numColors + " colors:");
        for (int i = 0; i < vertices; i++) {
            String name = colors[i] <= 6 ? colorNames[colors[i]] : "Color" + colors[i];
            System.out.println("  Vertex " + i + " -> " + name + " (" + colors[i] + ")");
        }
    }

    public static void main(String[] args) {
        GraphColoring graph = new GraphColoring(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Graph with 5 vertices:");
        System.out.println("Edges: (0,1) (0,2) (1,2) (1,3) (2,3) (3,4)");
        System.out.println();

        int chromatic = graph.findChromaticNumber();
        System.out.println("Chromatic Number: " + chromatic);
        System.out.println();

        System.out.println("Trying 3 colors:");
        graph.solveColoring(3);
        System.out.println();

        System.out.println("Trying 2 colors:");
        graph.solveColoring(2);
        System.out.println();

        List<int[]> allColorings = graph.findAllColorings(3);
        System.out.println("Total valid 3-colorings: " + allColorings.size());
    }
}
