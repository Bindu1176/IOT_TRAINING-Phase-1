import java.util.*;
public class SortedMatrix {
    static boolean search(int[][] matrix,int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        while(row<rows && col>=0) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col]>target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}
        };
        int target= 37;
        System.out.println("Found = "+search(matrix,target));
    }
}