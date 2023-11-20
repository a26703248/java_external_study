package blog.howardli.java_external_study.data_structure;

public class MyArrayMain {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        try {
            myArray.insert(3, 0);
            myArray.insert(7, 1);
            myArray.insert(9, 2);
            myArray.insert(5, 3);
            myArray.insert(6, 1);
            myArray.output();
            System.out.println("===============");
            myArray.delete(2);
            myArray.output();
            System.out.println("===============");
            myArray.update(2, 8);
            myArray.output();
            System.out.println("===============");
            System.out.println(myArray.find(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("超出数组实际元素范围！");
        }
        if (size >= array.length) {
            throw new Exception("数组已满！");
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public void delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("超出数组实际元素范围！");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int find(int element) {
        int index;
        for (index = 0; index < size; index++) {
            if (array[index] == element) {
                break;
            }
        }
        if (index == size) {
            return -1;
        } else {
            return index;
        }
    }

    public void update(int index, int element) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("超出数组实际元素范围！");
        }
        array[index] = element;
    }
}
