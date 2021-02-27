public class ZeroMatrix {
    public static final int N = 4;

    // if an element in an NxN matrix is 0, its entire row
    // and column are set to 0
    public static void modifyMatrix(int[][] matrix) {
        boolean[] rows = new boolean[N];
        boolean[] columns = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (rows[i] == true) { // nullify rows
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (columns[i] == true) { // nullify columns
                for (int j = 0; j < N; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix, String text) {
        System.out.println(text);
        for (int i = 0; i <  N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 4, 5}, {3, 0, 5, 6}, {1, 2, 0, 7}, {9, 3, 4, 5}};

        printMatrix(matrix, "Before:");
        modifyMatrix(matrix);
        printMatrix(matrix, "After:");

    }
}
