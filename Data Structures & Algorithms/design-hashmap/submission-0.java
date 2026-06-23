class MyHashMap {
    /*
    use an array with linkedlist to store all the key value pairs
    1. initialize an array, get the hashing by using key mod array size
    2. put the key value pair to the corresponding bucket
    3. handle the collision by using linkedlist
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
        // 这个和set不一样，set可以先检查存不存在，存在就直接返回，不存在才加
        // 但是map如果先检查了存不存在，我们都是要继续操作的，所以不如直接分情况操作
        // 存不存在的区别
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