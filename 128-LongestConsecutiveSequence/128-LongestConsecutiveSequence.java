class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max=0;

        for(int i : nums){
            set.add(i);
        }

        for(int i = 0; i<nums.length;i++){

            int current = nums[i];

            if(!set.contains(current)){
                continue;
            }

            int count= 1;
            set.remove(current);
            while(set.contains(current+1)){
                count++;
                current++;
                set.remove(current);
            }

            current = nums[i];

            while(set.contains(current-1)){
                count++;
                current--;
                set.remove(current);
            }

            max=Math.max(max,count);
        }

        return max;
    }
}