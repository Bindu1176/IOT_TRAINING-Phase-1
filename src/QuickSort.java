import java.util.*;
public class QuickSort {
    static void quickSort(int[] arr,int low,int high) {
        if(low<high) {
            int pivotIndex = partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    static int partition(int[] arr,int low,int high) {
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++) {
            if(arr[j]<=pivot) {
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {10,7,8,9,1,5};
        System.out.println("Before Sorting:"+Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("After Sorting:"+Arrays.toString(arr));
    }
}