// Last updated: 28/06/2025, 18:13:28
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> list = new HashSet<>();

        for(int i=0;i< nums.length;i++){
            int j = i+1;
            int k = nums.length-1;

            while(j<k){
                
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    List<Integer> l = new ArrayList<>();

                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);

                    list.add(l);
                    j++;
                    k--;
                }
                else if( sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }


        return new ArrayList<>(list);
    }
}