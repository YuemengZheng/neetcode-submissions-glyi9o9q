class TimeMap {
    // 本质上这个题目在用二分找target，如果没有target，找最大的小于target的值
    // find the largest timestamp that is <= target
    // so the value is list of [value, time] 
    // 将两个数据类型不同的放在一起，需要定义一个object去装
    // 有两个注意点，如果values是空的我们可以直接返回“”， 如果没有找到对应的符合条件的r应该会停留在-1，也需要返回“”
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
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Node> values = map.get(key);
        if(values == null) return "";

        int l = 0, r = values.size();
        while(l < r){
            int mid = l + (r - l) / 2;
            if(values.get(mid).time <= timestamp){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return r == 0 ? "" : values.get(l - 1).val;
    }
}
