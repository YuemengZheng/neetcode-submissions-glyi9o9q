class TimeMap {
    class Node{
        String val;
        int time;

        public Node(String val, int time){
            this.val = val;
            this.time = time;
        }
    }

    Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if(list == null) return "";
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).time > timestamp){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right >= 0? list.get(right).val : "";
        
    }
}
