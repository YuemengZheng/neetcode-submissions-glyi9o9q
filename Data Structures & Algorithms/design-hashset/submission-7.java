class MyHashSet {
    /*
    I'll use an array of LinkedLists. 
    Each key is mapped to a bucket using key mod array size. 
    Collisions are handled by storing multiple elements in the LinkedList at that bucket

    Because the maximum number of operations is around 10,000, 
    for the array size I'll use 769. This balances lookup efficiency and memory usage. 
    And since 769 is a prime number, it distributes the keys more evenly to reduce collisions. So I'll go with 769.
    Let me illustrate with a small size of 7. 
    If I add key 13, then 13 mod 7 is 6, so it goes into bucket 6. If I call contains(13), I go to bucket 6 and find it, so it returns true. 
    Then remove(13) goes to bucket 6 and removes it by value.
    */
    List<Integer>[] set;
    int size = 769;

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