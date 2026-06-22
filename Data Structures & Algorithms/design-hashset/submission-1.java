class MyHashSet {
    /*
    I'll use an array of LinkedLists. 
    Each key is mapped to a bucket using key mod array size. 
    Collisions are handled by storing multiple elements in the LinkedList at that bucket

    To balance lookup efficiency and memory usage,
    I'll use an array of size 10,000. 
    On average, each bucket will store around 100 elements, which keeps the lookup time close to O(1).
    */
    List<Integer>[] set;
    int size = 10000;

    public MyHashSet() {
        set = new LinkedList[size];
        for(int i = 0; i < size; i++){
            set[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        if(contains(key)) return;
        set[key % size].add(key);
    }
    
    public void remove(int key) {
        set[key % size].remove(Integer.valueOf(key));// remove by index => remove(index), remove by value (Integer.valueOf(key))
        
    }
    
    public boolean contains(int key) {
        return set[key % size].contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */