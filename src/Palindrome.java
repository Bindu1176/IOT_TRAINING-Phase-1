import java.util.*;
public class Palindrome {
    static void mergeSort(int[] arr,int left,int right) {
        if(left>=right)
            return;
        int mid = left + (right - left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    static void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right) {
            if(arr[i]<=arr[j]) {
                temp[k++]=arr[i++];
            } else {
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid)
            temp[k++]=arr[i++];
        while(j<=right)
            temp[k++]=arr[j++];
        for(i=0;i<temp.length;i++)
            arr[left+i]=temp[i];
    }
    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        System.out.println("Before sorting:"+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("After Sorting:"+Arrays.toString(arr));
    }
}