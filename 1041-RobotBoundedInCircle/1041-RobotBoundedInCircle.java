// Last updated: 16/06/2025, 17:06:44
class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int x = 0;
        int y = 0;

        int index = 0;

        for(int i=0; i < instructions.length(); i++){
            char in = instructions.charAt(i);

            if(in == 'G'){
                x = x + dx[index];
                y = y + dy[index];
            }
            else if( in == 'L'){
                index = (index+1)%4;
            }
            else{
                index = (index+3)%4;
            }
        }

        return (x==0 && y==0) || (index!=0);
    }
}