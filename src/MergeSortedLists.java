public class MergeSortedLists {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
    }
    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node current = dummy;
        while (a!=null && b!=null) {
            if(a.data<-b.data) {
                current.next=a;
                a=a.next;
            } else {
                current.next=b;
                b=b.next;
            }
            current = current.next;
        }
        if(a!=null)
            current.next=a;
        if(b!=null)
            current.next=b;
        return dummy.next;
    }
    static void display(Node head) {
        while(head!=null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("NULL");
    }
    static Node create(int... values) {
        Node head = null;
        Node tail = null;
        for(int value : values) {
            Node newNode = new Node(value);
            if(head==null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node list1 = create(10,30,50);
        Node list2 = create(20,40,60);
        Node result = merge(list1,list2);
        System.out.println("Merged List:");
        display(result);
    }
}