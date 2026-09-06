import java.util.*;
public class FibonacciDP {
    static int fibonacci(int n) {
        if(n<=1)
            return n;
        int prev2 = 0 ;
        int prev1 = 1 ;
        for(int i = 2 ; i <= n ; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n:");
        int n = sc.nextInt();
        System.out.println("Fibonacci = "+fibonacci(n));
        sc.close();
    }
}