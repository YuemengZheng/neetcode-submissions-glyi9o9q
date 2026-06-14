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
        // bsf
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        Node cur = node;
        q.offer(cur);
        map.put(cur, new Node(node.val));
        while(!q.isEmpty()){
            cur = q.poll();
            for(Node next : cur.neighbors){
                if(!map.containsKey(next)){
                    q.offer(next);
                    map.put(next, new Node(next.val));
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }
}