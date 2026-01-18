class Solution {
    public int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int maxRowIndex = -1;  // Result
        int j = m - 1;         // Start from top-right corner

        for (int i = 0; i < n; i++) {
            // Move left while there are 1s
            while (j >= 0 && mat[i][j] == 1) {
                maxRowIndex = i;
                j--;
            }
        }
        
        return maxRowIndex;
    }
}