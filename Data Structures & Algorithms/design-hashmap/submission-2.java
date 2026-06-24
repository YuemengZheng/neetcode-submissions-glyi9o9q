class MyHashMap {
   /*
    Before I start, can I clarify the constraints? 
    What's the range of the keys, and what's the maximum number of operations we'll perform?

    Use an array of LinkedLists to store all the key-value pairs.
    1. Initialize an array, compute the hash using key mod array size
    2. Put the key-value pair into the corresponding bucket
    3. Handle collisions by storing multiple key-value pairs in the LinkedList at that bucket


    Because the maximum number of operations is around 10,000, 
    for the array size I'll use 769. This balances lookup efficiency and memory usage. 
    And since 769 is a prime number, it distributes the keys more evenly to reduce collisions. So I'll go with 769.
    */

    List<int[]>[] array;
    int size;

    public MyHashMap() {
        size = 10000;
        array = new LinkedList[size];
        for(int i = 0; i < size; i++){
            array[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int hash = key % size;
        for(int[] pair : array[hash]){
            if(pair[0] == key){
                pair[1] = value;
                return;
            }
        }
        array[hash].add(new int[]{key, value});
    }
    
    public int get(int key) {
        int hash = key % size;
        for(int[] pair : array[hash]){
            if(pair[0] == key){
                return pair[1];
            }
        }
        return -1;   
    }
    
    public void remove(int key) {
        int hash = key % size;
        array[hash].removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */