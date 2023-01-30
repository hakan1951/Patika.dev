public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4,5,6}, {7,8,9}};
        printTranspose(matrix);
    }
    static int[][] transpose(int[][] matrix){
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    static void printTranspose(int[][] matrix){
        int[][] transposeMatrix = transpose(matrix);
        for (int[] row : transposeMatrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}