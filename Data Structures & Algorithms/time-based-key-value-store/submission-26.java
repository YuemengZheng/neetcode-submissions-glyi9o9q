class TimeMap {
    class Node {
        String value;
        int timestamp;
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Node>>map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if(list == null) return "";
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int time = list.get(mid).timestamp;
            if(time <= timestamp) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return r == -1 ? "" : list.get(r).value;
    }
}
