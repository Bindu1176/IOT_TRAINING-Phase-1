public class Main {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        int sum = 0;
        int n = arr.length;
        for (int i =0;i<n;i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
