import java.util.*;
public class LIS {
    static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int answer = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements : ");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("LIS Length = "+lis(arr));
        sc.close();
    }
}
