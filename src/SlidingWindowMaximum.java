import java.util.*;
public class SlidingWindowMaximum {
    static int[] maxSlidingWindow(int[] arr,int k) {
        if(arr.length==0 || k==0)
            return new int[0];
        int[] result = new int[arr.length-k+1];
        Deque<Integer>deque= new ArrayDeque<>();
        int resultIndex = 0;
        for(int i=0;i<arr.length;i++) {
            while(!deque.isEmpty() && deque.peekFirst()<=i-k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()]<=arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1) {
                result[resultIndex++]=arr[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] result = maxSlidingWindow(arr,k);
        System.out.println(Arrays.toString(result));
    }
}