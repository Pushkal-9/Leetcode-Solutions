// Last updated: 28/03/2025, 20:24:17
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a,b) -> {
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }

            return a.compareTo(b);
        });


        HashSet<String> set = new HashSet<>();

        for(String str : folder){
            String[] sf = str.split("/");

            String f = sf[0];

            int i=1;

            boolean skip = false;

            while(i<sf.length){
                //System.out.println(f);
                f= f+ "/" + sf[i];

                if( set.contains(f)){
                    skip=true;
                    break;
                }

                i++;
            }

            if(skip){
                continue;
            }

            //System.out.println(str);
            set.add(str);
        }

        List<String> res = new ArrayList<>(set);

        return res;
    }
}