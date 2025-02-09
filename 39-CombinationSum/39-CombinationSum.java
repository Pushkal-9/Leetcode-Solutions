class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        return sums(candidates,target,res,current,0,0);
    }

    public List<List<Integer>> sums(int[] arr, int target, List<List<Integer>> res, List<Integer> current,int index, int sum){
        if(index>=arr.length || sum>target){
            return res;
        }

        if(sum==target){
            res.add(new ArrayList<>(current));
            return res;
        }

        res = sums(arr,target,res,current,index+1,sum);

        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(arr[index]);

        res = sums(arr,target,res,newCurrent,index,sum+arr[index]);

        return res;
    }
}