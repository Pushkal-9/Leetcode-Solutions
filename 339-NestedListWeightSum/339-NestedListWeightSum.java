// Last updated: 19/06/2025, 18:41:02
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
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    Integer sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {

        for(NestedInteger integer : nestedList){
            dfs(integer,1);
        }

        return sum;
    }

    public void dfs(NestedInteger nestedInteger, int depth){
        if(nestedInteger.isInteger()){
            sum = sum + nestedInteger.getInteger()*depth;
            return;
        }

        for(NestedInteger nested : nestedInteger.getList()){
            dfs(nested,depth+1);
        }
    }
}