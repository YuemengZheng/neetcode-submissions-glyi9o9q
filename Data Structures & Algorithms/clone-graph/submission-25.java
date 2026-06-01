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
        // 写bfs的时候乱，因为搞不清楚放进queue意味着什么
        // 一开始确定，node放进queue就意味着已clone需要更新map
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        map.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node nei : cur.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}