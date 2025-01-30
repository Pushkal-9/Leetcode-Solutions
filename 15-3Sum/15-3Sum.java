class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                List<Integer> list = new ArrayList<>();
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    list.addAll(Arrays.asList(nums[i],nums[j],nums[k]));
                    resultSet.add(list);
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}