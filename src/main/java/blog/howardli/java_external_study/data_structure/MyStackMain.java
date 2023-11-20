package blog.howardli.java_external_study.data_structure;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
class MyStack {
    private int[] data;
    private int top;
    private int size;

    public MyStack(int size) {
        this.size = size;
        data = new int[size];
        top = -1;
    }

    public boolean push(int val) {
        if (top == size - 1) {
            return false;
        }
        data[++top] = val;
        return true;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}