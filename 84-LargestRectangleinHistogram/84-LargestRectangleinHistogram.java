class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] leftMin = new int[heights.length];
        int [] rightMin = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                    int cur = stack.pop();
                    rightMin[cur]=i-1;
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
                int cur = stack.pop();
                rightMin[cur]=heights.length-1;      
        }

        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                    int cur = stack.pop();
                    leftMin[cur]=i+1;
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
                int cur = stack.pop();
                leftMin[cur]=0;      
        }

        int max=0;

        for(int i=0;i<heights.length;i++){
            //System.out.println(heights[i] + " " + leftMin[i] + " " + rightMin[i]);
            max = Math.max(max,heights[i]*(rightMin[i]-leftMin[i]+1));
        }

        return max;

    }
}