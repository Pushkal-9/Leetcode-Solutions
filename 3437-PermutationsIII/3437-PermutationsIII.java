// Last updated: 20/04/2025, 20:51:04
class Solution {
    List<List<Integer>> result;
    int max;

    public int[][] permute(int n) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(i%2==0){
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }

        max=n;

        result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();


        permute(0, false, current, even, odd);
        permute(0, true, current, even, odd);

        result.sort((a, b) -> {
    for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
        if (!a.get(i).equals(b.get(i))) {
            return a.get(i) - b.get(i);
        }
    }
    return a.size() - b.size();
});


        int[][] res = new int[result.size()][n];

        for(int i=0;i<result.size(); i++){
            for(int j=0;j<result.get(0).size();j++)
                res[i][j] = result.get(i).get(j);
        }

        return res;
    }

    public void permute(int curIndex, boolean turn, List<Integer> current, List<Integer> even, List<Integer> odd){

        if(curIndex==max){
            result.add(new ArrayList<>(current));
            return;
        }

        if(turn){
            for(int i=0;i<even.size();i++){
                int element = even.get(i);
                current.add(element);
                even.remove(i);
                permute(curIndex+1,!turn, current, even, odd);
                current.remove(current.size()-1);
                even.add(i, element);
            }
        }
        else{
            for(int i=0;i<odd.size();i++){
                int element = odd.get(i);
                current.add(element);
                odd.remove(i);
                permute(curIndex+1,!turn, current, even, odd);
                current.remove(current.size()-1);
                odd.add(i, element);
            }           
        }
    }
}