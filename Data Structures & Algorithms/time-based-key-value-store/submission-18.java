class TimeMap {
    /*
    I'll use a HashMap to store keys, where each key maps to a list of timestamp-value pairs. 
    For the set function, I append the new timestamp-value pair to the list. 
    For the get function, since timestamps are sorted, 
    I use binary search to find the latest timestamp 
    that is less than or equal to the given timestamp.
    */
    class Node{
        int timestamp;
        String value;
        Node(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Node>> map;
    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));   
    }

    public String get(String key, int timestamp){
        if(map.get(key) == null) return "";
        List<Node> list = map.get(key);
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp <= timestamp){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right == -1 ? "" : list.get(right).value;
    }

}
