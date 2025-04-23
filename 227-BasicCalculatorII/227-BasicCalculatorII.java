// Last updated: 22/04/2025, 19:18:57
class Solution {
    public int calculate(String s) {
        List<String> list = new ArrayList<>();

        s = s.trim();
        int start = 0;

        while (start < s.length()) {
            if (s.charAt(start) == ' ') {
                start++;
                continue;
            }

            if (Character.isDigit(s.charAt(start))) {
                StringBuilder sb = new StringBuilder();
                while (start < s.length() && Character.isDigit(s.charAt(start))) {
                    sb.append(s.charAt(start));
                    start++;
                }
                list.add(sb.toString());
            } else {
                list.add(String.valueOf(s.charAt(start)));
                start++;
            }
        }

        List<String> curr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String token = list.get(i);
            if (token.equals("/") || token.equals("*")) {
                int prev = Integer.parseInt(curr.remove(curr.size() - 1));
                int next = Integer.parseInt(list.get(++i));
                int val = token.equals("/") ? prev / next : prev * next;
                curr.add(String.valueOf(val));
            } else {
                curr.add(token);
            }
        }

        list = new ArrayList<>(curr);
        curr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String token = list.get(i);
            if (token.equals("+") || token.equals("-")) {
                int prev = Integer.parseInt(curr.remove(curr.size() - 1));
                int next = Integer.parseInt(list.get(++i));
                int val = token.equals("+") ? prev + next : prev - next;
                curr.add(String.valueOf(val));
            } else {
                curr.add(token);
            }
        }

        return Integer.parseInt(curr.get(0));
    }
}
