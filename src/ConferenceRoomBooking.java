import java.util.*;
public class ConferenceRoomBooking {
    static class Node{
        char ch;
        int frequency;
        Node left;
        Node right;
        Node(char ch,int frequency){
            this.ch=ch;
            this.frequency=frequency;
        }
        Node(int frequency,Node left,Node right){
            this.frequency=frequency;
            this.left=left;
            this.right=right;
        }
    }
    static void printCodes(Node root,String code){
        if(root==null)
            return;
        if(root.left==null&& root.right==null){
            System.out.println(root.ch+":"+code);
            return;
        }
        printCodes(root.left,code+"0");
        printCodes(root.right,code+"1");
    }
    public static void main(String[] args){
        char[] characters={'A','B','C','D','E','F'};
        int[] frequencies={5,8,12,13,16,45};
        PriorityQueue<Node>pq=new PriorityQueue<>(Comparator.comparingInt(n->n.frequency));
        for(int i=0;i<characters.length;i++) {
            pq.add(new Node(characters[i],frequencies[i]));
        }
        while(pq.size()>1){
            Node first = pq.poll();
            Node second = pq.poll();
            Node combined = new Node(first.frequency + second.frequency,first,second);
            pq.add(combined);
        }
        Node root = pq.poll();
        System.out.println("Huffman Codes:");
        printCodes(root,"");
    }
}