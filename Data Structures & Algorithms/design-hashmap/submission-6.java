class MyHashMap {
   /*
    Goal:
    "Design a HashMap without using built-in hash table libraries."

    High level:
    "Use an array of LinkedLists. Each key is mapped to a bucket using key mod array size. 
    Collisions are handled by chaining — storing multiple key-value pairs in the LinkedList at that bucket."

    Main steps:
    "Initialize an array of size 769, which is a prime number to distribute keys evenly and reduce collisions.
    For put: compute the hash, check if the key already exists in the bucket — if so update the value, 
    otherwise add a new key-value pair.
    For get: compute the hash, iterate through the bucket to find the key and return its value, 
    return -1 if not found.
    For remove: compute the hash, use removeIf to remove the pair where the key matches."

    TC & SC:
    "Time complexity is O(n/k) per operation where n is the number of elements and k is the bucket size 769, 
    effectively O(1) on average. Space complexity is O(k + n) for the buckets and stored elements."
    */

    List<int[]>[] array;
    int size;

    public MyHashMap() {
        size = 769;
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
        array[hash].removeIf(pair -> pair[0] == key);//比较复杂条件的remove用removeIf
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */