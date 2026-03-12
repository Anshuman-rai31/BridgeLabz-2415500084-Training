import java.util.Arrays;

public class RatInMaze {

    private static final int[] ROW_DIR = {1, 0, -1, 0};
    private static final int[] COL_DIR = {0, 1, 0, -1};
    private static final String[] DIR_NAME = {"Down", "Right", "Up", "Left"};

    public boolean solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] solution = new int[n][n];
        for (int[] row : solution) Arrays.fill(row, 0);

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            System.out.println("No path exists.");
            return false;
        }

        solution[0][0] = 1;
        if (solve(maze, 0, 0, solution, n)) {
            printSolution(solution, n);
            return true;
        }

        System.out.println("No path exists.");
        return false;
    }

    private boolean solve(int[][] maze, int row, int col, int[][] solution, int n) {
        if (row == n - 1 && col == n - 1) {
            return true;
        }

        for (int d = 0; d < 4; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];

            if (isSafe(maze, newRow, newCol, solution, n)) {
                solution[newRow][newCol] = 1;

                if (solve(maze, newRow, newCol, solution, n)) {
                    return true;
                }

                solution[newRow][newCol] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int[][] maze, int row, int col, int[][] solution, int n) {
        return row >= 0 && row < n && col >= 0 && col < n
                && maze[row][col] == 1 && solution[row][col] == 0;
    }

    public void findAllPaths(int[][] maze) {
        int n = maze.length;
        int[][] solution = new int[n][n];
        solution[0][0] = 1;
        int[] pathCount = {0};

        if (maze[0][0] == 1 && maze[n - 1][n - 1] == 1) {
            findAll(maze, 0, 0, solution, n, pathCount);
        }

        System.out.println("Total paths found: " + pathCount[0]);
    }

    private void findAll(int[][] maze, int row, int col, int[][] solution, int n, int[] pathCount) {
        if (row == n - 1 && col == n - 1) {
            pathCount[0]++;
            System.out.println("Path " + pathCount[0] + ":");
            printSolution(solution, n);
            System.out.println();
            return;
        }

        for (int d = 0; d < 4; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];

            if (isSafe(maze, newRow, newCol, solution, n)) {
                solution[newRow][newCol] = 1;
                findAll(maze, newRow, newCol, solution, n, pathCount);
                solution[newRow][newCol] = 0;
            }
        }
    }

    private void printSolution(int[][] solution, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RatInMaze solver = new RatInMaze();

        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        System.out.println("Maze:");
        for (int[] row : maze) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Finding one path:");
        solver.solveMaze(maze);
        System.out.println();

        System.out.println("Finding all paths:");
        solver.findAllPaths(maze);
    }
}
