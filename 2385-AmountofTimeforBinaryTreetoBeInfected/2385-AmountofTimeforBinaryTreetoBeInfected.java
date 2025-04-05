// Last updated: 04/04/2025, 19:32:25
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int time = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return time;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        graph.computeIfAbsent(node.val, k -> new ArrayList<>());
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>());
            graph.get(parent.val).add(node.val);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}