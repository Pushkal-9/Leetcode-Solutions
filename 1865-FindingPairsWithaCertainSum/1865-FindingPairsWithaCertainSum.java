// Last updated: 04/05/2025, 18:23:54
class FindSumPairs {
    HashMap<Integer, Integer> map;
    int[] nums1;
    int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.map = new HashMap<>();

        this.nums1=nums1;
        this.nums2=nums2;

        for(int i : nums2){
            map.put(i, map.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int old = nums2[index];
        if(map.get(old)==1){
            map.remove(old);
        }
        else{
            map.put(old, map.get(old)-1);
        }

        int n = old + val;

        nums2[index] = n;

        map.put(n, map.getOrDefault(n,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;

        for(int i : nums1){
            int cur = tot-i;

            count = count + map.getOrDefault(cur,0);
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */