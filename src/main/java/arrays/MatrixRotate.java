package arrays;

public class MatrixRotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        matrix = rotateMatrix(matrix);
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        hasValidDimensions(matrix);

        for (int row = 0; row < Math.floor(matrix.length/2); row++) {
            for (int col = 0; col < matrix.length - (2*row) - 1; col++) {
                // A = matrix[row][row + col];
                // B = matrix[row + col][matrix[row].length - 1 - row];
                // C = matrix[matrix.length - 1 - row][matrix[row].length - 1 - row - col];
                // D = matrix[matrix.length - 1 - row - col][row];

                // Now we need to do a layer-by-layer variable swap
                int temp = matrix[row + col][matrix.length - 1 - row];
                matrix[row + col][matrix.length - 1 - row] = matrix[row][row + col];
                matrix[row][row + col] = temp;

                temp = matrix[matrix.length - 1 - row][matrix.length - 1 - row - col];
                matrix[matrix.length - 1 - row][matrix.length - 1 - row - col] = matrix[row][row + col];
                matrix[row][row + col] = temp;

                temp = matrix[matrix.length - 1 - row - col][row];
                matrix[matrix.length - 1 - row - col][row] = matrix[row][row + col];
                matrix[row][row + col] = temp;
            }
        }

        return matrix;
    }

    public static boolean hasValidDimensions(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Unable to rotate a null matrix");
        }
        // ensure that the dimensions of the input matrix are of the same size
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new IllegalArgumentException("Unable to process mismatched dimensions (NxM not supported)");
            }
        }
        return true;
    }
}
