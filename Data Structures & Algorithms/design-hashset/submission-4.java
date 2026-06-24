class MyHashSet {
    int size;
    List<Integer>[] arr;

    public MyHashSet() {
        size = 10000;
        arr = new LinkedList[size];
        for(int i = 0; i < size; i++){
            arr[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        if(contains(key)) return;
        arr[key % size].add(key);
    }
    
    public void remove(int key) {
        arr[key % size].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return arr[key % size].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */