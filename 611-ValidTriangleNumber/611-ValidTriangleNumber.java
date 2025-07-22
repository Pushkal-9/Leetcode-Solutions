// Last updated: 22/07/2025, 00:23:50
class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;

        Arrays.sort(nums);


        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isValid(nums[i], nums[j], nums[k])){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isValid(int x, int y, int z){
        if(x+y <= z){
            return false;
        }

        return true;
    }
}