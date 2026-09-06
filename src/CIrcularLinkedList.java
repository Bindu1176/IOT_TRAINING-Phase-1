public class CIrcularLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    Node head;
    Node tail;
    void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next=head;
        }
    }
    void display() {
        if(head == null)
            return;
        Node current = head;
        do {
            System.out.println(current.data+"->");
            current = current.next;
        } while(current!=head);
        System.out.println("(back to HEAD)");
    }
    public static void main(String[] args) {
        CIrcularLinkedList list = new CIrcularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();
    }
}