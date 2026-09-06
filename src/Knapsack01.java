import java.util.*;
public class Knapsack01 {
    static int knapsack(int[] weight,int[] value,int capacity) {
        int n = weight.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int i=1;i<=n;i++) {
            for(int w=0;w<=capacity;w++) {
                dp[i][w] = dp[i-1][w];
                if(weight[i-1]<=w) {
                    dp[i][w] = Math.max(dp[i][w],value[i-1]+dp[i-1][w-weight[i-1]]);
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items : ");
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        System.out.println("Enter weights : ");
        for(int i=0;i<n;i++)
            weight[i] = sc.nextInt();
        System.out.println("Enter Values : ");
        for(int i=0;i<n;i++)
            value[i] = sc.nextInt();
        System.out.println("Enter Capacity : ");
        int capacity = sc.nextInt();
        System.out.println("Maximum Value = "+knapsack(weight,value,capacity));
        sc.close();
    }
}