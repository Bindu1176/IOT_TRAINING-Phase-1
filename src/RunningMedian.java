import java.util.*;
public class RunningMedian {
    static PriorityQueue<Integer>maxHeap=new PriorityQueue<>(
            Collections.reverseOrder());
    static PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    static void addNumber(int number){
        if(maxHeap.isEmpty()||number<=maxHeap.peek()){
            maxHeap.add(number);
        }else{
            minHeap.add(number);
        }
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
    }
    static double getMedian(){
        if(maxHeap.size()==minHeap.size()){
            return(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
    public static void main(String[] args){
        int[] numbers={5,12,1,3,8};
        for(int number:numbers){
            addNumber(number);
            System.out.println("Added "+number+" -> Median = " +getMedian());
        }
    }
}