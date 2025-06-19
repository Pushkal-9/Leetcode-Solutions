// Last updated: 19/06/2025, 14:51:43
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> ancP = new ArrayList<>();
        List<Node> pAnc = ancestors(p, ancP);

        List<Node> ancQ = new ArrayList<>();
        List<Node> qAnc = ancestors(q, ancQ);

        Set<Node> set = new HashSet<>(qAnc);

        for(Node node : pAnc){
            if(set.contains(node)){
                return node;
            }
        }

        return null;

    }

    public List<Node> ancestors(Node node, List<Node> anc){
        if(node==null){
            return anc;
        }

        anc.add(node);

        return ancestors(node.parent, anc);
    }
}