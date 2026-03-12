import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<int[]> solveAllSolutions(int n) {
        List<int[]> solutions = new ArrayList<>();
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(queens, -1);
        solveAll(n, 0, queens, cols, diag1, diag2, solutions);
        return solutions;
    }

    private void solveAll(int n, int row, int[] queens, boolean[] cols,
                          boolean[] diag1, boolean[] diag2, List<int[]> solutions) {
        if (row == n) {
            solutions.add(queens.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row - col + n - 1] && !diag2[row + col]) {
                queens[row] = col;
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                solveAll(n, row + 1, queens, cols, diag1, diag2, solutions);

                queens[row] = -1;
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
    }

    public int[] solveFirst(int n) {
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(queens, -1);

        if (solveFirstHelper(n, 0, queens, cols, diag1, diag2)) {
            return queens;
        }
        return null;
    }

    private boolean solveFirstHelper(int n, int row, int[] queens, boolean[] cols,
                                      boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row - col + n - 1] && !diag2[row + col]) {
                queens[row] = col;
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                if (solveFirstHelper(n, row + 1, queens, cols, diag1, diag2)) {
                    return true;
                }

                queens[row] = -1;
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
        return false;
    }

    public int[] solveWithForbidden(int n, boolean[][] forbidden) {
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(queens, -1);

        if (solveWithForbiddenHelper(n, 0, queens, cols, diag1, diag2, forbidden)) {
            return queens;
        }
        return null;
    }

    private boolean solveWithForbiddenHelper(int n, int row, int[] queens, boolean[] cols,
                                              boolean[] diag1, boolean[] diag2, boolean[][] forbidden) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (!forbidden[row][col] && !cols[col] && !diag1[row - col + n - 1] && !diag2[row + col]) {
                queens[row] = col;
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                if (solveWithForbiddenHelper(n, row + 1, queens, cols, diag1, diag2, forbidden)) {
                    return true;
                }

                queens[row] = -1;
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
        return false;
    }

    public void traceNQueens4() {
        int n = 4;
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(queens, -1);
        traceHelper(n, 0, queens, cols, diag1, diag2);
    }

    private boolean traceHelper(int n, int row, int[] queens, boolean[] cols,
                                 boolean[] diag1, boolean[] diag2) {
        String indent = "  ".repeat(row);
        if (row == n) {
            System.out.println(indent + "ALL QUEENS PLACED! Solution: " + Arrays.toString(queens));
            return true;
        }

        System.out.println(indent + "Row " + row + ": trying columns...");
        System.out.println(indent + "  cols=" + Arrays.toString(cols));
        System.out.println(indent + "  diag1=" + Arrays.toString(diag1));
        System.out.println(indent + "  diag2=" + Arrays.toString(diag2));

        for (int col = 0; col < n; col++) {
            boolean colFree = !cols[col];
            boolean d1Free = !diag1[row - col + n - 1];
            boolean d2Free = !diag2[row + col];

            if (colFree && d1Free && d2Free) {
                System.out.println(indent + "  Place queen at (" + row + "," + col + ")");
                queens[row] = col;
                cols[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                if (traceHelper(n, row + 1, queens, cols, diag1, diag2)) {
                    return true;
                }

                System.out.println(indent + "  BACKTRACK: remove queen from (" + row + "," + col + ")");
                queens[row] = -1;
                cols[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            } else {
                System.out.println(indent + "  Column " + col + " invalid:"
                        + (!colFree ? " col-conflict" : "")
                        + (!d1Free ? " diag1-conflict" : "")
                        + (!d2Free ? " diag2-conflict" : ""));
            }
        }
        return false;
    }

    public void printBoard(int[] queens) {
        int n = queens.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(queens[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        System.out.println("=== Part (a): Search Space Analysis for 8-Queens ===");
        long bruteForce = 1;
        for (int i = 0; i < 8; i++) bruteForce *= 64;
        System.out.println("Brute force (any 8 of 64 squares): C(64,8) = 4,426,165,368");
        System.out.println("64^8 (with repetition) = " + bruteForce);
        long onePerRow = 1;
        for (int i = 0; i < 8; i++) onePerRow *= 8;
        System.out.println("One queen per row: 8^8 = " + onePerRow);
        System.out.println("With backtracking: ~15,720 nodes explored (empirical)");
        System.out.println("Backtracking prunes early when column/diagonal conflicts detected");
        System.out.println();

        System.out.println("=== Part (b) & (c): Optimized N=4 with Trace ===");
        System.out.println("Using 1D array queens[row]=col, diagonal arrays for O(1) conflict check");
        System.out.println("diag1[row-col+n-1] tracks '\\' diagonals");
        System.out.println("diag2[row+col] tracks '/' diagonals");
        System.out.println();
        solver.traceNQueens4();
        System.out.println();

        System.out.println("=== Part (d): Find FIRST solution only (8-Queens) ===");
        int[] first8 = solver.solveFirst(8);
        if (first8 != null) {
            System.out.println("First solution for 8-Queens: " + Arrays.toString(first8));
            solver.printBoard(first8);
        }
        System.out.println("Optimization: return true immediately upon finding first complete placement");
        System.out.println();

        System.out.println("=== Part (e): N-Queens with Forbidden Squares (8-Queens) ===");
        boolean[][] forbidden = new boolean[8][8];
        forbidden[0][0] = true;
        forbidden[1][1] = true;
        forbidden[2][2] = true;
        forbidden[3][3] = true;
        System.out.println("Forbidden squares: (0,0), (1,1), (2,2), (3,3)");
        int[] forbiddenSolution = solver.solveWithForbidden(8, forbidden);
        if (forbiddenSolution != null) {
            System.out.println("Solution with forbidden squares: " + Arrays.toString(forbiddenSolution));
            solver.printBoard(forbiddenSolution);
        } else {
            System.out.println("No solution exists with given forbidden squares.");
        }
        System.out.println("Impact: Additional constraint check reduces valid placements per row");
        System.out.println("Worst case remains O(N!) but practical performance may worsen or improve");
        System.out.println();

        System.out.println("=== All solutions count for N=1 through N=10 ===");
        for (int n = 1; n <= 10; n++) {
            List<int[]> solutions = solver.solveAllSolutions(n);
            System.out.println("N=" + n + ": " + solutions.size() + " solutions");
        }
    }
}
