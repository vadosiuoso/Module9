package Module9;

public class MyHashMap<K,V> {
    private Node head;
    public MyHashMap(){
        this.head = null;
    }
    private class Node<K, V>{
        private K key;
        private V value;
        private Node next;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public void put(K key, V value) throws Exception {
        Node current = this.head;
        while (current != null){
            if(current.key.equals(key)){
                throw new Exception("Node with this key is already available");
            }
            current = current.next;
        }
        Node newNode = new Node<>(key, value);
        newNode.next = this.head;
        this.head = newNode;
    }
    public void remove(K key) throws Exception {
        Node current = this.head;
        Node previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    this.head = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new Exception("Node with this key not found");
    }

    public void clear(){
        this.head = null;
    }

    public int size(){
        int size = 0;
        Node current = this.head;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    public Object get(K key) throws Exception {
        Node current = this.head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        throw new Exception("Node with this key not found");
    }
}




