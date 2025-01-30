class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i=0;i<=s2.length()-s1.length();i++){
            if(matches(s1,s2.substring(i,i+s1.length()))){
                return true;
            }
        }

        return false;
    }

    public boolean matches(String s1,String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        s1 = new String(str1);
        s2 = new String(str2);

        return s1.equals(s2);
    }
}