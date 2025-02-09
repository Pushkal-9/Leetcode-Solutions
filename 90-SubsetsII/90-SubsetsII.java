class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        return new ArrayList<>(subsets(nums,res,current,0));
    }

    public HashSet<List<Integer>> subsets(int[]nums, HashSet<List<Integer>> res, List<Integer> current, int index){
        if(index>=nums.length){
            res.add(new ArrayList<>(current));
            return res;
        }

        res = subsets(nums,res,current,index+1);
        List<Integer> path2 = new ArrayList<>(current);
        path2.add(nums[index]);
        res = subsets(nums,res,path2,index+1);

        return res;
    }
}