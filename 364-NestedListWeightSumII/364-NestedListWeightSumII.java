// Last updated: 28/03/2025, 20:47:46
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private int sum = 0;
    private int max = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {

        for(NestedInteger node : nestedList){
            maxDepth(node,1);
        }

        //System.out.println(max);

        for(NestedInteger node : nestedList){
            dfs(node,1);
        }

        return sum;
    }

    public void dfs(NestedInteger node, int depth){
        if(node.isInteger()){
            sum = sum + node.getInteger() *(max - depth + 1);
            return;
        }

        List<NestedInteger> list = node.getList();

        for(NestedInteger child : list){
            dfs(child,depth+1);
        }

    }

    public void maxDepth(NestedInteger node, int depth){
        if(node.isInteger()){
            max=Math.max(max,depth);
            return;
        }

        List<NestedInteger> list = node.getList();

        for(NestedInteger child : list){
            maxDepth(child,depth+1);
        }

    }
}