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
        /*
        I can also solve this with BFS and a HashMap. 
        I'll start by cloning the input node and adding it to the queue. 
        Then for each node in the queue, if its neighbors haven't been cloned yet, 
        I'll clone them, add them to the queue, and build the connections.
        */
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        map.put(node, new Node(node.val));
        q.offer(node);// **** ERROR1 *****
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node nei : cur.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val));
                    q.offer(nei); // **** ERROR2 *****
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}