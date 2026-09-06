public class SinglyLinkedListDemo {
    static class Node {
        int data;
        Node next;
        Node(int data) {
         this.data=data;
         this.next=null;
        }
    }
    Node head;
    void insert(int data) {
        Node newNode = new Node(data);
        if(head==null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next!=null) {
            current = current.next;
        }
        current.next=newNode;
    }
    void delete(int value) {
        if(head==null)
            return;
        if (head.data==value) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next!=null) {
            if(current.next.data==value) {
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
    }
    void display() {
        Node current = head;
        while(current!=null) {
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        SinglyLinkedListDemo list = new SinglyLinkedListDemo();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Original List:");
        list.display();
        list.delete(20);
        System.out.println("After Deleting 20:");
        list.display();
    }
}