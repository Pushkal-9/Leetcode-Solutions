// Last updated: 25/06/2025, 22:16:21
/*
// Definition for a Node.
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
        Map<Integer, Node> map = new HashMap<>();

        return dfs(node,map);
    }

    public Node dfs(Node node, Map<Integer, Node> map){
        if(node == null){
            return node;
        }

        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node cur = new Node(node.val);

        map.put(node.val,cur);

        for(Node neigh : node.neighbors){
            cur.neighbors.add(dfs(neigh, map));
        }

        return cur;
    }
}