package Module9;

public class MyArrayList<V> {
    private V[] array;
    private int size;

    public MyArrayList(){
        size = 16;
        array = (V[]) new Object[size];
    }

    public void add(V value){
        if(array[array.length-1] != null){
            resizeArray();
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = value;
                break;
            }
        }
    }
    public void remove(int index){
        V tmp = array[index];
        if(index<size()){
            array[index] = null;
            createNewArray(array);
        }
    }
    public V get(int index){
        return array[index];
    }

    private void createNewArray(V[] array) {
        V[] mass = (V[]) new Object[array.length];
        int j = 0;
        for(int i = 0; i< array.length; i++){
            mass[j] = (array[i] != null) ? array[i] : array[++i];
            j++;
            if (array[i] == null && array[i+1] == null){
                break;
            }
        }
        this.array = mass;
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

    public void clear(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }
    public void resizeArray(){
        size+=16;
        V[] tmp = (V[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }
}
