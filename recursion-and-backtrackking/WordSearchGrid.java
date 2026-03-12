public class WordSearchGrid {

    private int rows;
    private int cols;
    private static final int[] ROW_DIR = {-1, 1, 0, 0};
    private static final int[] COL_DIR = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (search(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int d = 0; d < 4; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];

            if (search(board, word, newRow, newCol, index + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    public int countOccurrences(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    count += countSearch(board, word, i, j, 0, visited);
                }
            }
        }
        return count;
    }

    private int countSearch(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return 1;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || board[row][col] != word.charAt(index)) {
            return 0;
        }

        visited[row][col] = true;
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int newRow = row + ROW_DIR[d];
            int newCol = col + COL_DIR[d];
            count += countSearch(board, word, newRow, newCol, index + 1, visited);
        }

        visited[row][col] = false;
        return count;
    }

    public static void main(String[] args) {
        WordSearchGrid solver = new WordSearchGrid();

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println("Board:");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();

        String[] words = {"ABCCED", "SEE", "ABCB", "FCSE"};
        for (String word : words) {
            System.out.println("Word \"" + word + "\" exists: " + solver.exist(board, word));
        }

        System.out.println();
        System.out.println("Occurrences of \"SEE\": " + solver.countOccurrences(board, "SEE"));
    }
}
