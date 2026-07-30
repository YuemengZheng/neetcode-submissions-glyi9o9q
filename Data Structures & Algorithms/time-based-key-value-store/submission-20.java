class TimeMap {

    class Pair {
        String value;
        int time;
        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    // Map<String, List<Pair<String, Integer>>> map;
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp++));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(list.get(mid).time <= timestamp) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return r < 0 ? "" : list.get(r).value;
    }
}
