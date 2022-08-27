package Module9;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();


        MyLinkedList<Integer> arr1 = new MyLinkedList<>();
        arr1.add(3);
        arr1.add(1);
        arr1.add(2);
        arr1.add(5);
        arr1.add(4);


        MyStack<Integer> stack = new MyStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}