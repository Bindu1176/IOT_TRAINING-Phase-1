import java.util.Scanner;
public class MatrixMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Maximum in each row:");
        for (int i = 0; i < rows; i++) {
            int rowMax = matrix[i][0];
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > rowMax) {
                    rowMax = matrix[i][j];
                }
            }
            System.out.println("Row " + (i + 1) + ": " + rowMax);
        }
        System.out.println("Maximum in each column:");
        for (int j = 0; j < cols; j++) {
            int colMax = matrix[0][j];
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] > colMax) {
                    colMax = matrix[i][j];
                }
            }
            System.out.println("Column " + (j + 1) + ": " + colMax);
        }
        int overallMax = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > overallMax) {
                    overallMax = matrix[i][j];
                }
            }
        }
        System.out.println("Overall maximum element: " + overallMax);
        sc.close();
    }
}
