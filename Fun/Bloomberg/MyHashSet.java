package Fun.Bloomberg;

public class MyHashSet {
    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[buckets][];
    }

    private int findIndex(int key) {
        return Integer.hashCode(key) % buckets;
    }

    public int position(int key) {
        return Integer.hashCode(key) % itemsPerBucket;
    }

    public void add(int key) {
        int hashkey = findIndex(key);

        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][position(key)] = true;
    }

    public void remove(int key) {
        int hashkey = findIndex(key);

        if (table[hashkey] != null)
            table[hashkey][position(key)] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashkey = findIndex(key);
        return table[hashkey] != null && table[hashkey][position(key)];
    }
}
