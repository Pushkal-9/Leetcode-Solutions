// Last updated: 15/04/2025, 19:15:59
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
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();

        return cloneDfs(node,map);

    }

    public Node cloneDfs(Node node, HashMap<Node,Node> map){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node cur = new Node(node.val);
        map.put(node,cur);

        for(Node n : node.neighbors){
            if(map.containsKey(n)){
                cur.neighbors.add(map.get(n));
            }
            else{
                cur.neighbors.add(cloneDfs(n,map));
            }
        }

        return cur;
    }
}