import java.util.*;

class Solution {
      public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) return Collections.emptyList();
        int rc = heights.length;
        int cc = heights[0].length;
        Set<List<Integer>> pVisited = new HashSet<>();
        
        for (int i=0; i<cc; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pVisited);
        }
        
        for (int i=0; i<rc; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pVisited);
        }
        
        Set<List<Integer>> aVisited = new HashSet<>();
        
        for (int i=0; i<cc; i++) {
            dfs(heights, rc-1, i, Integer.MIN_VALUE, aVisited);
        }
        
        for (int i=0; i<rc; i++) {
            dfs(heights, i, cc-1, Integer.MIN_VALUE, aVisited);
        }
        
        pVisited.retainAll(aVisited);
        
        return new ArrayList<List<Integer>>(pVisited);
        
    }
    
    public void dfs(int[][] heights, int r, int c, int height, Set<List<Integer>> visited) {
        if (r < 0 || r >= heights.length 
            || c < 0 || c >= heights[0].length 
            || visited.contains(List.of(r,c))
            || heights[r][c] < height) {
            return;
        }
        
        visited.add(List.of(r,c));
        dfs(heights, r+1, c, heights[r][c], visited);
        dfs(heights, r-1, c, heights[r][c], visited);
        dfs(heights, r, c+1, heights[r][c], visited);
        dfs(heights, r, c-1, heights[r][c], visited);
    }
}
