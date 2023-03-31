package Module9;

public class MyLinkedList<V>{
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public MyLinkedList(){
        tail = new Node<V>(head, null, null);
        head = new Node<V>(null, null, tail);
    }

    private class Node<V>{
        private V value;
        private Node<V> next;
        private Node<V> previous;

        public Node(Node<V> previous, V value, Node<V> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }

    public void add(V value){
        Node<V> lastNode = tail;
        lastNode.value = value;
        tail = new Node<>(lastNode, null, null);
        lastNode.next = tail;
        size++;
    }

    public void remove(int index){
        if(index<0 || index>size()-1){
            System.out.println("Invalid index");
            return;
        }else if(index == size()-1){
            removeLast();
        }else if(index == 0){
            removeFirst();
        }else {
            Node<V> tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            tmp.next.previous = tmp.next.previous.previous;
            size--;
        }
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public V get(int index) {
        try {
            if (index < 0 || index > size() - 1) {
                throw new Exception();
            }
            Node tmp = head;
            for (int i = 0; i <= index; i++) {
                tmp = tmp.next;
            }
            return (V) tmp.value;
        } catch (Exception e) {
            System.out.println("Invalid index");
            return null;
        }
    }

    private void removeFirst() {
        head = head.next;
        head.value = null;
        size--;
    }

    private void removeLast() {
        tail = tail.previous;
        tail.value = null;
        size--;
    }
}



