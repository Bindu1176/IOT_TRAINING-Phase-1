public class DoublyLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    Node head;
    Node tail;
    void insert(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head=tail=newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    void forwardDisplay() {
        Node current = head;
        while(current!=null) {
            System.out.println(current.data+"<->");
            current = current.next;
        }
        System.out.println("NULL");
    }
    void backwardDisplay() {
        Node current = tail;
        while(current!=null) {
            System.out.println(current.data+"<->");
            current = current.prev;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Forward:");
        list.forwardDisplay();
        System.out.println("Backward:");
        list.backwardDisplay();
    }
}