class MyHashMap {
    // use a arr of linkedlists to store pair of elements
    int size = 769;
    List<int[]>[] map;
    public MyHashMap() {
        map = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            map[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        List<int[]> list = map[key % size];
        for(int[] pair : list) {
            if(pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        list.add(new int[]{key, value});
    }
    
    public int get(int key) {
        List<int[]> list = map[key % size];
        for(int[] pair : list) {
            if(pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        map[key % size].removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */