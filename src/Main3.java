import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main3 {
    static class FastScanner {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
                StringTokenizer st;
                String next() throws IOException {
                    while(st==null||!st.hasMoreTokens()) {
                        st = new StringTokenizer(br.readLine());
                    }
                    return st.nextToken();
                }
                int nextInt() throws IOException {
                    return Integer.parseInt(next());
                }
                long nextLong() throws IOException {
                    return Long.parseLong(next());
                }
    }
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long sum = 0;
        for(int i=0;i<n;i++) {
            sum += fs.nextLong();
        }
        System.out.println(sum);
    }
}