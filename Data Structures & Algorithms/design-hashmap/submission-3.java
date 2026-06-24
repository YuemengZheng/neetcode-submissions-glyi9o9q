class MyHashMap {
    int size;
    List<int[]>[] arr;
    
    public MyHashMap() {
        size = 769;
        arr = new LinkedList[size];
        for(int i = 0; i < size; i++){
            arr[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        for(int[] pair : arr[key % size]){
            if(pair[0] == key){
                pair[1] = value;
                return;
            }
        }
        arr[key % size].add(new int[]{key, value});
    }
    
    public int get(int key) {
        for(int[] pair : arr[key % size]){
            if(pair[0] == key) return pair[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        arr[key % size].removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */