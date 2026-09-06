import java.util.Scanner;

public class SubsetSum {
    static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++){
                dp[i][sum] = dp[i-1][sum];

                if (arr[i-1] <= sum){
                    dp[i][sum] = dp[i][sum] || dp[i-1][sum-arr[i-1]];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (subsetSum(arr, target))
            System.out.print("Subset exists");
        else
            System.out.print("Subset does not exist");
        sc.close();
    }
}