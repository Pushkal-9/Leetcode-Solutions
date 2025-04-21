// Last updated: 20/04/2025, 20:52:51
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public int[][] permute(int n) {
        List<Integer> even = getEvenNumbers(n);
        List<Integer> odd = getOddNumbers(n);

        backtrack(new ArrayList<>(), even, odd, true, n);  
        backtrack(new ArrayList<>(), even, odd, false, n); 

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

    private void backtrack(List<Integer> current, List<Integer> even, List<Integer> odd, boolean isEvenTurn, int n) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        List<Integer> source = isEvenTurn ? even : odd;

        for (int i = 0; i < source.size(); i++) {
            int val = source.get(i);
            current.add(val);
            source.remove(i);
            backtrack(current, even, odd, !isEvenTurn, n);
            source.add(i, val);
            current.remove(current.size() - 1);
        }
    }

    private List<Integer> getEvenNumbers(int n) {
        List<Integer> evens = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) evens.add(i);
        return evens;
    }

    private List<Integer> getOddNumbers(int n) {
        List<Integer> odds = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) odds.add(i);
        return odds;
    }
}