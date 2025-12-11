package LR_6;

import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException(
                    "Stack overflow: попытка добавить элемент в полный стек (capacity = " + data.length + ")"
            );
        }
        data[size++] = element;
    }
    public T pop() {
        if (size == 0)
            return null;
        T removedItem = data[size - 1];
        data = Arrays.copyOf(data, size - 1);
        size--;

        return removedItem;
    }
    public T peek() {
        if (size == 0) return null;
        return data[size - 1];
    }

    static void main() {
        Stack<String> stack = new Stack<>(5);
        System.out.println(stack.size);
        stack.push("Oracle");
        System.out.println(stack.size);
        System.out.println(stack.peek());
        stack.push("Oracle");
        stack.push("Oracle");
        stack.push("Oracle");
        stack.push("Oracle");
        // stack.push("Oracle");
        System.out.println(stack.size);
        stack.pop();
        System.out.println(stack.size);
    }
}