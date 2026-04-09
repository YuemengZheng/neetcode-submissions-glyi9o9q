class TimeMap {
    // 本质上这个题目在用二分，找最后一个time <=timestemp 的value
    // 首先我们需要用一个object to store value and timestamp
    // 用hashmap存储key to list of value and timestamp pair
    
    class Node {
        int time;
        String val;
        
        Node(int time, String val){
            this.time = time;
            this.val = val;
        }
    }
    private Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Node> values = map.get(key);
        if(values == null) return "";

        int l = 0, r = values.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(values.get(mid).time <= timestamp){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r == -1 ? "" : values.get(r).val;
    }
}
