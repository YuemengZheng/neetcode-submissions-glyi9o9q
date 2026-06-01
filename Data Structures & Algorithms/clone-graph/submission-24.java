/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!map.containsKey(cur)){
                map.put(cur, new Node(cur.val));
            }
            Node clone = map.get(cur);
            for(Node nei : cur.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                clone.neighbors.add(map.get(nei));
            }

        }
        return map.get(node);
        
    }
}