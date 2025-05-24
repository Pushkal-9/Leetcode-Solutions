// Last updated: 24/05/2025, 17:53:29
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public int[][] permute(int n) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        helper(n,odd,even);
        
        perm(n,true,odd,even,new ArrayList<>());
        perm(n,false,odd,even,new ArrayList<>());

        result.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });

        
        int[][] res = new int[result.size()][n];
        for (int i = 0; i < result.size(); i++)
            for (int j = 0; j < n; j++)
                res[i][j] = result.get(i).get(j);

        return res;

    }

    public void perm(int n, boolean isEven, List<Integer> odd, List<Integer> even, List<Integer> cur){
        if(cur.size()==n){
            result.add(new ArrayList<>(cur));
            return;
        }

        List<Integer> source = isEven ? even : odd;

        for(int i=0;i<source.size();i++){
            int ele = source.get(i);
            cur.add(ele);
            source.remove(i);
            perm(n, !isEven, odd, even, cur);
            source.add(i,ele);
            cur.remove(cur.size()-1);
        }
    }

    public void helper(int n, List<Integer> odd, List<Integer> even){
        for(int i=1;i<=n;i++){
            if(i%2==0){
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }
    }
}