public class MyQueue<V> {
    private Node<V> head;
    private int size;

    public MyQueue() {
        this.head = null;
    }

    private class Node<V>{
        private V value;
        private Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public void add(V value){
        Node<V> current = head;
        Node<V> newNode = new Node<>(value);
        head = newNode;
        newNode.next = current;
        size++;
    }

    public int size(){
        return size;
    }

    public Object peek(){
        Node<V> tmp = head;
        for(int i = 0; i < size()-1; i++){
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public Object poll(){
        Node<V> tmp = head;
        for(int i = 0; i < size()-1; i++){
            tmp = tmp.next;
        }
        removeLast();
        return tmp.value;
    }

    public void cleat(){
        head = null;
    }

    private void removeLast(){
        Node<V> tmp = head;
        for (int i = 0; i < size()-2; i++) {
            tmp = tmp.next;
        }
        tmp.next = null;
        size--;
    }
}
