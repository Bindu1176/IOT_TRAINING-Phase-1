import java.util.*;
public class BinarySearch
{
    static boolean canProduce(int[] machines, long days,long target){
        long total=0;
        for(int machine:machines){
            total+=days/machine;
            if(total>=target){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long target=sc.nextLong();
        int[] machines=new int[n];
        for(int i=0;i<n;i++){
            machines[i]=sc.nextInt();
        }
        long low=1;
        long high=(long)Arrays.stream(machines).min().getAsInt()*target;
        long answer=high;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(canProduce(machines,mid,target)){
                answer=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println("Minimum Days="+answer);
        sc.close();
    }
}