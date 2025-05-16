// Last updated: 15/05/2025, 20:18:46
class Solution {
    List<List<Integer>> powerSet;
    public List<List<Integer>> subsets(int[] nums) {
        powerSet = new ArrayList<>();

        dfs(0,new ArrayList<>(),nums);

        return powerSet;
    }

    public void dfs(int index, List<Integer> current, int[] nums){
        if(index>=nums.length){
            powerSet.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        dfs(index+1,current,nums);
        current.remove(current.size()-1);
        dfs(index+1,current,nums);

    }
}