import java.util.Objects;
public class MyHashSet<E> {
    private int size = 0;
    private E element;
    private int CAPACITY = 10;
    private  MyTrashcan[] buckets;
    public MyHashSet(){
        this.buckets = new MyTrashcan[CAPACITY];
    }
    private int getHash(E element){
        return element.hashCode() & 0xfffffff % CAPACITY;
    }
    private MyValueEntry getEntry(E value){
        int hash = getHash(value);
        for (int i = 0; i <buckets[hash].getEntry().size(); i++) {
            MyValueEntry myValueEntry = buckets[hash].getEntry().get(i);
            if (myValueEntry.getElement().equals(value)){
                return myValueEntry;
            }
        }
        return null;
    }
    public boolean containsValue(E value){
        int hash = getHash(value);
        return !(Objects.isNull(buckets[hash]) || Objects.isNull(getEntry(value)));
    }
    public void put(E value){
        if (containsValue(value)){
            throw new RuntimeException("В множестве может быть только уникальные значения");
        }
        else {
            int hash = getHash(value);
            if (buckets[hash] == null){
                buckets[hash] = new  MyTrashcan();
            }
            buckets[hash].addEntry(new MyValueEntry<>(value));
            size++;
        }
    }
    public E get(E value){
        return containsValue(value) ? (E) getEntry(value).getElement() : null;
    }
    public void remove(E value){
        if(!containsValue(value)){
            throw new RuntimeException("Такого элемента не существует");
        }
        int hash = getHash(value);
        buckets[hash].removeEntry(getEntry(value));
    }
}