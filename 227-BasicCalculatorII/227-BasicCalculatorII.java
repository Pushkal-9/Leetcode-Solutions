// Last updated: 19/06/2025, 18:08:22
class Solution {
    public int calculate(String s) {
        List<String> list = sanatizeExpression(s);

        List<String> cur = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            String current = list.get(i);
            if(current.equals("/") || current.equals("*")){
                String prev = cur.get(cur.size()-1);
                String next = list.get(i+1);

                Integer first = Integer.parseInt(prev);
                Integer second = Integer.parseInt(next);

                Integer val;

                if(current.equals("/")){
                    val = first / second;
                }
                else{
                    val = first * second;
                }

                cur.remove(cur.size()-1);
                cur.add(String.valueOf(val));
                i++;
            }
            else{
                cur.add(String.valueOf(current));
            }
        }

        list = new ArrayList<>(cur);
        cur = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            String current = list.get(i);
            if(current.equals("+") || current.equals("-")){
                String prev = cur.get(cur.size()-1);
                String next = list.get(i+1);

                Integer first = Integer.parseInt(prev);
                Integer second = Integer.parseInt(next);

                Integer val;

                if(current.equals("+")){
                    val = first + second;
                }
                else{
                    val = first - second;
                }

                cur.remove(cur.size()-1);
                cur.add(String.valueOf(val));
                i++;
            }
            else{
                cur.add(String.valueOf(current));
            }
        }

        return Integer.parseInt(cur.get(0));
    }

    public List<String> sanatizeExpression(String s){

        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == ' '){
                continue;
            }

            if(ch == '/' || ch == '*' || ch == '+' || ch == '-'){

                res.add(sb.toString());
                res.add(String.valueOf(ch));
                sb = new StringBuilder();

            }
            else{
                sb.append(ch);
            }
        }


        if(!sb.isEmpty()){
            res.add(sb.toString());
        }

        return res;
    }
}