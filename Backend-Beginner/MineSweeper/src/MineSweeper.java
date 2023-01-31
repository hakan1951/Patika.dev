import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private final int rowNumber;
    private final int columnNumber;
    private int mineNumber;
    private final String[][] matrix;
    private final String[][] copyMatrix;

    public MineSweeper(int rowNumber, int columnNumber) {
        if ((rowNumber < 3 && columnNumber < 3)){
            throw new IllegalArgumentException("Number of rows or columns can not be smaller than 2.\n" +
                    "\t\t\t\tMatrix should be bigger than 2x2.");
        }
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.mineNumber = (rowNumber * columnNumber) / 4;
        this.matrix = new String[rowNumber][columnNumber];
        this.copyMatrix = new String[rowNumber][columnNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                matrix[i][j] = "-";
                copyMatrix[i][j] = "-";
            }
        }
    }
    public void run(){
        createGameMap();
        play();
    }
    public void createGameMap(){
        createRandomMines();
        System.out.println("Map created. You can start playing.");
        printCurrentMap();
    }
    public void createRandomMines(){
        Random r = new Random();
        while (mineNumber > 0){
            int row = r.nextInt(matrix.length);
            int column = r.nextInt(matrix[0].length);
            if (!matrix[row][column].equals("*")) {
                matrix[row][column] = "*";
                copyMatrix[row][column] = "0";
                mineNumber--;
            }
        }
    }
    public void printCurrentMap(){
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                if (matrix[i][j].equals("*")){ //123123123213
                    System.out.print("-");
                }else{
                    System.out.print(matrix[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void play() {
        Scanner sc = new Scanner(System.in);
        int control = 2;
        while (true) {
            //noinspection StatementWithEmptyBody
            if (control > 0) { //dummy escape from NullPointer for copyMatrix.
            } else {
                if (isWon(copyMatrix)){
                    System.out.println("Congratulations. You won.");
                    break;
                }
            }
            System.out.print("Row: ");
            int row = sc.nextInt();
            System.out.print("Column: ");
            int column = sc.nextInt();
            if ((row >= 0 && row < matrix.length) && (column >= 0 && column < matrix[0].length)) {
                if (isLost(row, column)) {
                    System.out.println("You lost the game. Better luck next time.");
                    break;
                }
                matrix[row][column] = totalMinesAround(row, column);
                copyMatrix[row][column] = totalMinesAround(row, column);
                System.out.println("----------");
                printCurrentMap();
                System.out.println("----------");
            } else {
                System.out.println("Invalid input. Enter a valid input.");
            }
            control--;
        }
    }
    public String totalMinesAround(int row, int column){
        int result = 0;
        if (matrix[row][column].equals("")){
            return "";
        }
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                    if (matrix[i][j] != null && matrix[i][j].equals("*")) {
                        result++;
                    }
                }
            }
        }
        return String.valueOf(result);
    }
    public boolean isLost (int row, int column){
            if (matrix[row][column].equals("*")) {
                System.out.println("Game Over");
                return true;
            }
            return false;
        }
    public boolean isWon (String[][] copyMatrix){
        for (String[] strings : copyMatrix) {
            for (int j = 0; j < copyMatrix[0].length; j++) {
                if (Objects.equals(strings[j], "-")) {
                    return false;
                }
            }
        }
        for (int i = 0; i < copyMatrix.length; i++) {
            for (int j = 0; j < copyMatrix[0].length; j++) {
                if (Objects.equals(copyMatrix[i][j], "-")) {
                    matrix[i][j] = "*";
                }
            }
        }
        printCurrentMap();
        return true;
    }
}
