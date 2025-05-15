// Last updated: 15/05/2025, 17:26:20
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> vis = new HashSet<>();

        int max=0;

        for(int i : nums){
            set.add(i);
        }

        for(int i = 0; i<nums.length;i++){

            int current = nums[i];

            if(vis.contains(current)){
                continue;
            }

            int count= 1;
            vis.add(current);
            while(set.contains(current+1)){
                count++;
                current++;
                vis.add(current);
            }

            current = nums[i];

            while(set.contains(current-1)){
                count++;
                current--;
                vis.add(current);
            }

            max=Math.max(max,count);
        }

        return max;
    }
}