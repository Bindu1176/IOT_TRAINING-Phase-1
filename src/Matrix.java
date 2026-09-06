import java.util.*;

class Matrix {
    static void transpose(int a[][], int m, int n) {
        for(int j=0; j<n; j++) {
            for(int i=0; i<m; i++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        System.out.println("Enter elements:");
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                a[i][j] = sc.nextInt();
        System.out.println("Transpose : ");
        transpose(a, m, n);
    }
}
