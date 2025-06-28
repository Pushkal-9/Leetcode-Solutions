// Last updated: 28/06/2025, 14:31:58
class Solution {
    public int maximumSwap(int num) {
        int[] lastIndex = new int[10];

        char[] arr = String.valueOf(num).toCharArray();

        for(int i=0 ; i<arr.length;i++){
            lastIndex[arr[i] - '0'] = i;
        }

        for(int i=0;i<arr.length;i++){
            for(int d=9;d>=0;d--){
                int cur = arr[i] -'0';
                if(cur < d){
                    if(lastIndex[d] > i){
                        swap(arr,i,lastIndex[d]);
                        return Integer.parseInt(String.valueOf(arr));
                    }
                }
            }
        }
        return num;
    }

    public void swap(char[] arr, int i, int j){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}