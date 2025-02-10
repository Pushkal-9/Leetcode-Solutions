class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        HashMap<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        return comb(digits,map,res,"",0);
    }

    public List<String> comb(String digits, HashMap<Character,String> map, List<String> res, String current, int index){
        if(index>=digits.length()){
            if(!current.isEmpty()){
                res.add(current);
                }
            return res;
        }

        String str = map.get(digits.charAt(index));

        for(Character ch : str.toCharArray()){
            String s = current + String.valueOf(ch);
            res = comb(digits,map,res,s,index+1);
        }

        return res;
    }
}