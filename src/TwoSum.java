import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        HashMap<Integer,Integer>map = new HashMap<>();
        boolean found = false;
        for(int i=0;i<n;i++) {
            int needed = target-arr[i];
            if(map.containsKey(needed)) {
                System.out.println("Indices : "+map.get(needed)+" "+i);
                System.out.println("Values : "+needed+" "+arr[i]);
                found = true;
                break;
            }
            map.put(arr[i],i);
        }
        if(!found) {
            System.out.println("No Pair found");
        }
        sc.close();
    }
}
