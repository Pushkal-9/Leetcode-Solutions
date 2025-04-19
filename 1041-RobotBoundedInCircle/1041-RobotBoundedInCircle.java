// Last updated: 19/04/2025, 13:40:22
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;

        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};

        int directionIndex = 0;

        for(char ch : instructions.toCharArray()){
            if(ch=='G'){
                x = x + dx[directionIndex];
                y = y + dy[directionIndex];
            }
            else if(ch=='L'){
                directionIndex = (directionIndex + 1)%4;
            }
            else if(ch=='R'){
                directionIndex = (directionIndex + 3)%4;
            }
        }

        return (x==0 && y==0) || directionIndex!=0;
    }
}