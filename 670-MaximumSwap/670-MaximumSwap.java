class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        return Integer.parseInt(maxSwap(str));
    }

    public String maxSwap(String str){
        if(str.length()==0){
            return "";
        }
        int index=0;
        char[] arr = str.toCharArray();
        char max = arr[0];
        boolean swap = false;
        for(int i=arr.length-1;i>=0;i--){
            char cur = arr[i];
            if(cur>max){
                swap=true;
                max=cur;
                index=i;
            }
        }
        if(swap){
            char first = arr[0];
            arr[0]=max;
            arr[index]=first;
            return String.valueOf(arr);
        }

        String partialString = new String(arr, 1, arr.length - 1);
        String res = arr[0] + maxSwap(partialString);

        return res;
    }
}