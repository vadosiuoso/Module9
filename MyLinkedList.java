package Module9;

import groovyjarjarantlr4.v4.misc.Graph;

import java.util.LinkedList;


public class MyLinkedList<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public MyLinkedList(){
        lstNode = new Node<E>(null,fstNode,null);
        fstNode = new Node<E>(null,null,lstNode);
    }
    public void add(E e){
        Node<E> prev=lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<>(null, prev,null);
        prev.setNextElement(lstNode);
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index > size()) {
            System.out.println("Invalid index");
            return;
        } else if (index == 0) {
            removeFirst();
        } else if (index == size() - 1) {
            removeLast();
        } else {
            Node<E> temp = fstNode;
            for (int i = 0; i < index-1; i++) {
                temp = getNextElement(temp);
            }
            temp.nextElement = temp.nextElement.nextElement;
            size--;
        }

    }
    public void removeLast() {
        lstNode = lstNode.prevElement;
        size--;
    }

    public void removeFirst(){
        fstNode = fstNode.nextElement;
        size--;
    }
    public void clear(){
        fstNode = null;
        lstNode = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public E get(int index){
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }
    public Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }

    public class Node<E> {
        private E currentElement;
        private Node<E> prevElement;
        private Node<E> nextElement;

        public Node(E currentElement, Node<E> prevElement, Node<E> nextElement){
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }
    }



}



