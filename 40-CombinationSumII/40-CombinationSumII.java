class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2(candidates,target,0,0,list,res);

        return res;
    }

    public void combinationSum2(int[] candidates, int target, int curSum, int index, List<Integer> list, List<List<Integer>> res) {
        
        if(curSum==target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(curSum>target || index>=candidates.length){
            return;
        }

        int skipIndex = index;

        while(skipIndex<candidates.length-1 && candidates[skipIndex]==candidates[skipIndex+1]){
            skipIndex++;
        }

        skipIndex++;
        combinationSum2(candidates,target,curSum,skipIndex,list,res);

        list.add(candidates[index]);
        combinationSum2(candidates,target,curSum+candidates[index],index+1,list,res);
        list.remove(list.size()-1);
    }
}