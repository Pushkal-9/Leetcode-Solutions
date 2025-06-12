// Last updated: 12/06/2025, 00:42:57
class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int[] suffixMax = new int[n];

        suffixMax[n-1] = Integer.MIN_VALUE;

        for(int i = n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1],heights[i+1]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(heights[i]>suffixMax[i]){
                list.add(i);
            }
        }

        int[] res = new int[list.size()];

        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }

        return res;
    }
}