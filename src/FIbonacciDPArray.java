import java.util.*;
public class FIbonacciDPArray {
    static int fibonacci(int n) {
        if(n<=1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.println("Fibonacci = "+fibonacci(n));
        sc.close();
    }
}
