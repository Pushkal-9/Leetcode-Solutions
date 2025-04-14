// Last updated: 14/04/2025, 15:46:05
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] pre = new int[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=1;i<=nums.length;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }

        for(int i=0;i<pre.length;i++){
            if(map.containsKey(pre[i]-k)){
                res=res+map.get(pre[i]-k);
            }
                
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);
        }

        return res;
    }
}