public class CycleDetection {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
    }
    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        if(hasCycle(first))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}
