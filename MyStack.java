public class MyStack<V> {
    private Node<V> head;
    private int size;

    public MyStack() {
        this.head = null;
    }

    private class Node<V> {
        private V value;
        private Node<V> next;

        private Node(V value) {
            this.value = value;
        }
    }
    
    public int size(){
        return size;
    }

    public void push(V value){
        Node<V> current = head;
        Node<V> newNode = new Node<>(value);
        head = newNode;
        newNode.next = current;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > size() - 1){
            System.out.println("Invalid index");
            return;
        }
        Node<V> tmp = head;
        for (int i = 0; i <= index; i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
    }

    public void clear(){
        head = null;
    }

    public V peek() {
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return head.value;

    }

    public V pop(){
        if(head == null){
            System.out.println("Stack is empty");
            return null;
        }
        V v = head.value;
        head = head.next;
        size--;
        return v;
    }
}
