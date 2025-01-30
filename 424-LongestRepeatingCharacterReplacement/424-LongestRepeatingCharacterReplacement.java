class Solution {
    public int characterReplacement(String s, int k) {
        
        int max=0;

        for(int i=0;i<26;i++){
            int count = k;
            int start=0;
            int end=0;
            while(end<s.length()){
                //System.out.println(s.charAt(end)-'A');
                if((s.charAt(end)-'A')!=i){
                    if(count==0){
                        if((s.charAt(start)-'A')!=i){
                            count++;
                        }
                        start++;
                    }
                    else{
                        count--;
                        end++;
                    }
                }
                else{
                    end++;
                }
                max=Math.max(end-start,max);
            }
        }

        return max;
    }
}