// Last updated: 28/06/2025, 14:22:37
class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];

        for (int i = 0; i < arr.length; i++) {
            lastIndex[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (lastIndex[d] > i) {

                    char temp = arr[i];
                    arr[i] = arr[lastIndex[d]];
                    arr[lastIndex[d]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}