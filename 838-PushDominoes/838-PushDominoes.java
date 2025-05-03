// Last updated: 03/05/2025, 18:58:41
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        char[] arr = dominoes.toCharArray();

        int force = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n;
            } else if (arr[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n;
            } else if (arr[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        for (int i = 0; i < n; i++) {
            if (forces[i] > 0) {
                arr[i] = 'R';
            } else if (forces[i] < 0) {
                arr[i] = 'L';
            } else {
                arr[i] = '.';
            }
        }

        return new String(arr);
    }
}
