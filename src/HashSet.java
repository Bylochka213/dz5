import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashSet {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int capacity;
    private double loadFactor;
    private int size;
    private List<List<Integer>> bucketi;

    public HashSet() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.bucketi = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.bucketi.add(new LinkedList<>());
        }
    }

    public void add(int value) {
        if (!contains(value)) {
            if (size >= capacity * loadFactor) {
                resize();
            }
            int bucketIndex = getBucketIndex(value);
            bucketi.get(bucketIndex).add(value);
            size++;
        }
    }

    public void remove(int value) {
        int bucketIndex = getBucketIndex(value);
        List<Integer> bucket = bucketi.get(bucketIndex);
        if (bucket.contains(value)) {
            bucket.remove(Integer.valueOf(value));
            size--;
        }
    }

    public boolean contains(int value) {
        int bucketIndex = getBucketIndex(value);
        List<Integer> bucket = bucketi.get(bucketIndex);
        return bucket.contains(value);
    }

    private void resize() {
        capacity *= 2;
        size = 0;
        List<List<Integer>> oldBuckets = bucketi;
        bucketi = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            bucketi.add(new LinkedList<>());
        }
        for (List<Integer> bucket : oldBuckets) {
            for (int value : bucket) {
                add(value);
            }
        }
    }

    private int getBucketIndex(int value) {
        return Math.abs(value) % capacity;
    }
}
