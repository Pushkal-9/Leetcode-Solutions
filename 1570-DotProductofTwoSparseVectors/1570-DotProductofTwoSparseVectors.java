// Last updated: 19/06/2025, 19:07:14
class SparseVector {
    Map<Integer,Integer> map;
    
    SparseVector(int[] nums) {
        this.map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                map.put(i,nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;

        for(Integer index : map.keySet()){
            if(vec.map.containsKey(index)){
                product += map.get(index) * vec.map.get(index);
            }
        }

        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);