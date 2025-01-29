public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(int i=0;i<strs.size();i++){
            strs.set(i,strs.get(i).replace("#", "##"));
        }

        StringBuffer encoded = new StringBuffer();

        for(String str : strs){
            encoded.append(str).append(" # ");
        }
        System.out.println(encoded.toString());
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        String[] array = s.split(" # ",-1);
        for(int i=0;i<array.length-1;i++){
            String st = array[i];
            strs.add(st.replace("##","#"));
        } 

        return strs; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));