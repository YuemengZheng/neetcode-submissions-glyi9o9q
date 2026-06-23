class MyHashSet {
    int size;
    List<Integer>[] array;

    public MyHashSet() {
        size = 10000;
        array = new LinkedList[size];
        for(int i = 0; i < size; i++){
            array[i] = new LinkedList<>();
        }
        
    }
    
    public void add(int key) {
        if(array[key % size].contains(key)) return;
        array[key % size].add(key);
    }
    
    public void remove(int key) {
        array[key % size].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return array[key % size].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */