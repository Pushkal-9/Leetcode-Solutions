// Last updated: 13/04/2025, 20:46:14
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indexes = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                indexes.add(i);
            }
        }

        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int occurence = queries[i];
            if(indexes.size()<occurence){
                res[i]=-1;
                continue;
            }

            res[i]=indexes.get(occurence-1);
        }

        return res;
    }
}