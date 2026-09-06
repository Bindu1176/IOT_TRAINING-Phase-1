import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
public class SpiralMatrix {
    static void spiral(int[][] matrix) {
        int top=0;
        int bottom = matrix.length-1;
        int left=0;
        int right = matrix[0].length-1;
        while(top<=bottom && left<=right) {
            for(int j=left;j<=right;j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
            for(int i=top;i<=bottom;i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if(top<=bottom) {
                for(int j=right;j>=left;j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }
            if(left<=right) {
                for(int i=bottom;i>=top;i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        spiral(matrix);
    }
}
