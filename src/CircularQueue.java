public class CircularQueue {
    int[] queue;
    int front = -1;
    int rear = -1;
    int size;
    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }
    boolean isFull() {
        return (rear+1)%size==front;
    }
    boolean isEmpty() {
        return front == -1;
    }
    void enqueue(int value) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty())
            front = 0;
        rear = (rear+1)%size;
        queue[rear] = value;
        System.out.println(value+"inserted");
    }
    void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int value = queue[front];
        System.out.println(value+"removed");
        if(front == rear){
            front = rear = -1;
        } else {
            front = (front + 1)%size;
        }
    }
    void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        while(true) {
            System.out.println(queue[i]+"");
            if(i==rear)
                break;
            i = (i+1)%size;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();
        q.dequeue();
        q.dequeue();
        q.enqueue(50);
        q.enqueue(60);
        q.display();
    }
}