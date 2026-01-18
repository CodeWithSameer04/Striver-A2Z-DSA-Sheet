class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int midCol = left + (right - left) / 2;
            
            // Find the row with max value in midCol
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            int leftNeighbor = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightNeighbor = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;
            
            if (mat[maxRow][midCol] > leftNeighbor && mat[maxRow][midCol] > rightNeighbor) {
                // Found a peak
                return new int[]{maxRow, midCol};
            } else if (leftNeighbor > mat[maxRow][midCol]) {
                right = midCol - 1; // move to left half
            } else {
                left = midCol + 1; // move to right half
            }
        }
        
        return new int[]{-1, -1}; // theoretically won't reach here
    }
}
