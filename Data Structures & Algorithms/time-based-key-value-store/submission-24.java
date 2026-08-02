class TimeMap {
    /*
    Goal
    "The problem is: for each key, we store multiple values with different timestamps. 
    When we query with a timestamp, we return the value with the largest timestamp that is 
    less than or equal to the query timestamp."

    High Level
    "I use a hash map. Each key maps to a list of value-timestamp pairs. 
    The timestamps are always increasing, so the list is already sorted. 
    Because it's sorted, I can use binary search."

    Main Steps
    "For set, I add the new pair to the list for that key.
    For get, first I check if the key exists. If not, I return empty string.
    If it exists, I binary search the list. I want the rightmost pair 
    whose timestamp is less than or equal to the target. 
    So if the middle timestamp is less than or equal to target, 
    I move left up, because there might be a closer answer on the right. 
    If it's greater, I move right down.
    After the loop, right points to the answer. 
    If right is negative one, no valid pair exists, so I return empty string. 
    Otherwise I return the value at right."

    Example
    "Let's say I call:
    set('foo', 'bar1', 1)
    set('foo', 'bar2', 3)
    set('foo', 'bar3', 5)

    So the list for key 'foo' is: timestamp 1 → 'bar1', timestamp 3 → 'bar2', timestamp 5 → 'bar3'.

    Case one — timestamp exactly matches an entry.
    get('foo', 3). Timestamp 3 exists exactly in the list, so I return 'bar2'.

    Case two — timestamp falls between two entries.
    get('foo', 4). There's no entry at timestamp 4, 
    but the largest timestamp less than or equal to 4 is 3. So I return 'bar2', same as before.

    Case three — timestamp is smaller than every entry.
    get('foo', 0). Every timestamp in the list — 1, 3, 5 — is bigger than 0. 
    So there's no valid answer. right ends up at negative one, and I return empty string.

    Case four — timestamp is larger than every entry.
    get('foo', 10). All timestamps are less than or equal to 10, 
    so the rightmost one, 5, is the answer. I return 'bar3'.

    Case five — the key was never set.
    get('baz', 3). Key 'baz' was never called with set, so map.get('baz') is null, 
    and I return empty string directly, without even doing binary search."

    Complexity
    "set is O(1). get is O(log n), because of binary search. Space is O(n) total."
    
    node是我们自己定义的，所以是class不是泛型，不需要写成List<Node<String, Integer>>
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
