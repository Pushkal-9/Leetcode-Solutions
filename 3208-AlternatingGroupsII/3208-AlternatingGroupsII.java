class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0;
        int end = 0;

        int count = 0;

        int n = colors.length;

        while(start<n){
            if(colors[end%n]!=colors[(end+1)%n]){
                end++;
            }
            else{
                start=end+1;
                end=start;
            }

            while(end-start+1>k){
                start++;
            }
            //System.out.println(start+ " "  +end);
            if(start<n && end-start+1==k){
                count++;
            }
        }

        return count;
    }
}