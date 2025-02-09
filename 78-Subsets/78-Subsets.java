class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        return subsets(nums,res,current,0);
    }

    public List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, List<Integer> current, int index){
        if(index>=nums.length){
            res.add(current);
            return res;
        }
        List<Integer> path2 = new ArrayList<>(current);   

        path2.add(nums[index]);
        int newIndex = index;
        res = subsets(nums,res,current,index+1);
        res = subsets(nums,res,path2,newIndex+1);

        return res;
    }
}