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
        // iteration
        // map the original node to the cloned node
        // use a queue to expand the nodes
        // for each node, check if it is already exist, use the clone
        // else clone the node and store in map
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        map.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node next : cur.neighbors){
                if(!map.containsKey(next)){
                    map.put(next, new Node(next.val));
                    q.offer(next);
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }
}