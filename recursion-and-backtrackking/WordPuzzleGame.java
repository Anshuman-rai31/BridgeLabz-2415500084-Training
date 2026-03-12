import java.util.ArrayList;
import java.util.List;

public class WordPuzzleGame {

    private int rows;
    private int cols;
    private static final int[] ROW_DIR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_DIR = {-1, 0, 1, -1, 1, -1, 0, 1};

    public boolean findWord(char[][] grid, String word) {
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (search(grid, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int d = 0; d < 8; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];
            if (search(grid, word, newRow, newCol, index + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    public List<List<int[]>> findAllPaths(char[][] grid, String word) {
        rows = grid.length;
        cols = grid[0].length;
        List<List<int[]>> allPaths = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    List<int[]> currentPath = new ArrayList<>();
                    searchAll(grid, word, i, j, 0, visited, currentPath, allPaths);
                }
            }
        }
        return allPaths;
    }

    private void searchAll(char[][] grid, String word, int row, int col, int index,
                           boolean[][] visited, List<int[]> currentPath, List<List<int[]>> allPaths) {
        if (index == word.length()) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || grid[row][col] != word.charAt(index)) {
            return;
        }

        visited[row][col] = true;
        currentPath.add(new int[]{row, col});

        for (int d = 0; d < 8; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];
            searchAll(grid, word, newRow, newCol, index + 1, visited, currentPath, allPaths);
        }

        visited[row][col] = false;
        currentPath.remove(currentPath.size() - 1);
    }

    public void traceSearch(char[][] grid, String word) {
        rows = grid.length;
        cols = grid[0].length;

        System.out.println("Tracing search for \"" + word + "\":");
        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    System.out.println("Starting from (" + i + "," + j + ") = '" + grid[i][j] + "'");
                    if (traceSearchHelper(grid, word, i, j, 0, visited, 1)) {
                        System.out.println("FOUND!");
                        return;
                    }
                    System.out.println("Not found from this starting point.");
                    System.out.println();
                }
            }
        }
        System.out.println("Word not found in grid.");
    }

    private boolean traceSearchHelper(char[][] grid, String word, int row, int col, int index,
                                       boolean[][] visited, int depth) {
        String indent = "  ".repeat(depth);

        if (index == word.length()) {
            System.out.println(indent + "All characters matched!");
            return true;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        if (visited[row][col]) {
            System.out.println(indent + "(" + row + "," + col + ") already visited - BACKTRACK");
            return false;
        }

        if (grid[row][col] != word.charAt(index)) {
            System.out.println(indent + "(" + row + "," + col + ") = '" + grid[row][col] + "' != '" + word.charAt(index) + "' - BACKTRACK");
            return false;
        }

        System.out.println(indent + "(" + row + "," + col + ") = '" + grid[row][col] + "' matches '" + word.charAt(index) + "' - CHOOSE");
        visited[row][col] = true;

        for (int d = 0; d < 8; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];
            if (traceSearchHelper(grid, word, newRow, newCol, index + 1, visited, depth + 1)) {
                return true;
            }
        }

        System.out.println(indent + "No valid neighbor for next char - UNCHOOSE (" + row + "," + col + ")");
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordPuzzleGame game = new WordPuzzleGame();

        char[][] grid = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
        };

        System.out.println("Grid:");
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("=== Part (a) & (b) & (c): Search for DREAM with trace ===");
        System.out.println();
        game.traceSearch(grid, "DREAM");
        System.out.println();

        System.out.println("=== Part (d): Complexity Analysis ===");
        System.out.println("Worst-case time complexity: O(N * M * 8^L)");
        System.out.println("  N x M = grid dimensions (starting points)");
        System.out.println("  8^L = branching factor 8 (directions) to depth L (word length)");
        System.out.println("  Backtracking prunes many branches in practice");
        System.out.println();

        System.out.println("=== Part (e): Finding ALL paths for DREAM ===");
        List<List<int[]>> allPaths = game.findAllPaths(grid, "DREAM");
        System.out.println("Total ways to form \"DREAM\": " + allPaths.size());
        for (int p = 0; p < allPaths.size(); p++) {
            System.out.print("  Path " + (p + 1) + ": ");
            for (int[] cell : allPaths.get(p)) {
                System.out.print("(" + cell[0] + "," + cell[1] + ") ");
            }
            System.out.println();
        }
        System.out.println("Modification: Instead of returning on first match, collect all solutions in a List");
        System.out.println();

        String[] testWords = {"DREAM", "CATS", "CORE", "DEAL", "AREA", "HELLO"};
        System.out.println("=== Testing multiple words ===");
        for (String word : testWords) {
            boolean found = game.findWord(grid, word);
            int count = game.findAllPaths(grid, word).size();
            System.out.println("\"" + word + "\": found=" + found + ", totalPaths=" + count);
        }
    }
}
