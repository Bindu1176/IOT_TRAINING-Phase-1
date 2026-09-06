public class ZAlgorithm {
    static void search(String text,String pattern) {
        String combined = pattern+"$"+text;
        int n = combined.length();
        int[] z = new int[n];
        int left = 0;
        int right = 0;
        for(int i=1;i<n;i++) {
            if(i<=right) {
                z[i] = Math.min(right-i+1,z[i-left]);
            }
            while(i+z[i]<n && combined.charAt(z[i])==combined.charAt(i+z[i])) {
                z[i]++;
            }
            if(i+z[i]-1>right) {
                left=i;
                right=i+z[i]-1;
            }
        }
        for(int i=0;i<n;i++) {
            if(z[i]==pattern.length()) {
                int index = i-pattern.length()-1;
                System.out.println("Pattern found at index "+index);
            }
        }
    }
    public static void main(String[] args) {
        String text = "ABABDABABCABAB";
        String pattern = "ABAB";
        search(text,pattern);
    }
}