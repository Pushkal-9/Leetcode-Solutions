// Last updated: 13/04/2025, 22:47:28
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> row = new ArrayList<>();

        row.add(1);

        result.add(row);


        if(numRows==1){
            return result;
        }

        for(int i=2;i<=numRows;i++){
            row = new ArrayList<>();

            row.add(1);

            for(int j=1;j<i-1;j++){
                int first = result.get(result.size()-1).get(j-1);
                int second = result.get(result.size()-1).get(j);

                row.add(first+second);
            }

            row.add(1);
            result.add(row);
            
        }

        return result;
    }
}