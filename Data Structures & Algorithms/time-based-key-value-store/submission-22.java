class TimeMap {
    // build a data structure that can store multiple values for the same key at diff time stamps
    // map, key is the key, value is a list of value time pairs
    // when we call set, we put the value time pair to the list
    // when we call get, we wanna find the value with the largest prev time stamp
    // time is incrasing, so we can use binary search to find that value
    class Pair {
        String value;
        int time;

        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";
        int l = 0; int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int t = list.get(mid).time;
            if(t <= timestamp) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return r == -1 ? "" : list.get(r).value;
    }
}
