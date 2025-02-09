class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remaining = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for(int num : nums){
            remaining.add(num);
        }
        return permute(res,current,remaining);
    }

    public List<List<Integer>> permute(List<List<Integer>> res,List<Integer> current, List<Integer> remaining){

        if(remaining.size()==0){
            res.add(new ArrayList<>(current));
            return res;
        }

        for(int i=0;i<remaining.size();i++){
            int value = remaining.get(i);
            ArrayList<Integer> cur = new ArrayList<>(remaining);
            current.add(value);
            cur.remove(i);
            res = permute(res,current,cur);
            current.remove(current.size()-1);
        }

        return res;
    }
}