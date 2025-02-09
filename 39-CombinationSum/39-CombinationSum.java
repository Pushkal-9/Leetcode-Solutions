class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        HashSet<List<Integer>> set = sums(candidates,target,res,current,0,0);
        return new ArrayList<>(set);
    }

    public HashSet<List<Integer>> sums(int[] arr, int target, HashSet<List<Integer>> res, List<Integer> current,int index, int sum){
        if(index>=arr.length || sum>target){
            return res;
        }

        if(sum==target){
            res.add(current);
            return res;
        }

        res = sums(arr,target,res,current,index+1,sum);

        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(arr[index]);

        res = sums(arr,target,res,newCurrent,index,sum+arr[index]);

        res = sums(arr,target,res,newCurrent,index+1,sum+arr[index]);

        return res;
    }
}