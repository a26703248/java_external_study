package blog.howardli.java_external_study.data_structure;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}
class MyQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int size) {
        this.size = size;
        data = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean enqueue(int val) {
        if (rear == size - 1) {
            return false;
        }
        data[++rear] = val;
        return true;
    }

    public int dequeue() {
        if (front == rear) {
            return -1;
        }
        return data[++front];
    }

    public int peek() {
        if (front == rear) {
            return -1;
        }
        return data[front + 1];
    }

    public boolean isEmpty() {
        return front == rear;
    }
}