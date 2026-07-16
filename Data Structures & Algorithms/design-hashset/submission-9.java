class MyHashSet {
    int size = 769;
    List<Integer>[] set;

    public MyHashSet() {
        set = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            set[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        if(contains(key)) return;
        set[key % size].add(key);
    }
    
    public void remove(int key) {
        set[key % size].remove(Integer.valueOf(key));
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