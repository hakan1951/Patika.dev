import java.util.Arrays;

public class MyList<T> {
    private T[] genericArray;
    private int size;

    public MyList(){
        int DEFAULT_SIZE = 10;
        genericArray = (T[]) new Object[DEFAULT_SIZE];
    }
    public MyList(int capacity){
        genericArray = (T[]) new Object[capacity];
    }
    public int size(){
        return size;
    }
    public int getCapacity(){
        return genericArray.length;
    }
    public void add(T data){
        for (int i = 0; i <= genericArray.length; i++){
            if (genericArray[i] == null){
                genericArray[i] = data;
                size++;
                break;
            }
        }
        ensureCapacity();
    }
    public void ensureCapacity(){
        if (size == genericArray.length){
            genericArray = Arrays.copyOf(genericArray, 2 * genericArray.length);
        }
    }
    public T get(int index){
        return genericArray[index];
    }
    public void remove(int index){
        if (index < 0 || index >= size){
            System.out.println("Invalid index.");
            return;
        }
        T removedData = genericArray[index];
        for (int i = index; index < size-1; i++){
            genericArray[i] = genericArray[i+1];
        }
        genericArray[size-1] = null;
        size--;
    }
    public void set(int index, T data){
        if (index < 0 || index >= size){
            System.out.println("Invalid index.");
            return;
        }
        genericArray[index] = data;
    }
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            str.append(genericArray[i]);
            if (genericArray[i+1] != null){
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }
    public int indexOf(T data){
        for (int i = 0; i < size; i++){
            if (genericArray[i].equals(data)){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        int returnIndex = -1;
        for (int i = 0; i < size; i++){
            if (genericArray[i].equals(data)){
                returnIndex = i;
            }
        }
        return returnIndex;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T[] toArray(){
        return Arrays.copyOf(genericArray, size);
    }
    public void clear(){
        Arrays.fill(genericArray, null);
        size = 0;
    }
    public MyList<T> subList(int start, int finish){
        if (start < 0 || finish >= size || start > finish){
            throw new IndexOutOfBoundsException("Invalid range.");
        }
        MyList<T> rangedList = new MyList<>(finish-start+1);
        for (int i = start; i <= finish; i++){
            rangedList.add(genericArray[i]);
        }
        return rangedList;
    }
    public boolean contains(T data){
        for (int i = 0; i < size; i++){
            if (genericArray[i].equals(data)){
                return true;
            }
        }
        return false;
    }
}