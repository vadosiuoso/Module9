package Module9;

public class MyQueue<E> {
    private int size;
    private E[] array;

public MyQueue() {
    this.size = 16;
    this.array = (E[]) new Object[size];
}
    public boolean add(E e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = e;
                return true;
            }
        }
        return false;
    }
    public E remove(int index){
        E tmp = array[index];
        if(index<size()){
            array[index] = null;
            createNewArray(array);
        }
        return tmp;
    }
    private void createNewArray(E[] array) {
        E[] mass = (E[]) new Object[array.length];
        int j = 0;
        for(int i = 0;i< array.length;i++){
            mass[j] = (array[i] != null) ? array[i] : array[++i];
            j++;
            if (array[i] == null && i+1<size && array[i+1] == null){
                break;
            }
        }
        this.array = mass;
    }
    public void clear(){
        for(int i = 0;i< array.length;i++){
            array[i] = null;
        }
    }
    public int size() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return count;
            } else count++;
        }
        return count;
    }
    public E peek(){
        E e = array[0];
        return e;
        }

    public E poll(){
        E e = array[0];
        return (e == null) ? null : remove(0);
    }
}
