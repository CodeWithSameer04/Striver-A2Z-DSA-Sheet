class Solution {
    public int findMedian(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find global min and max
        for (int i = 0; i < m; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][n - 1]);
        }
        
        int desired = (m * n + 1) / 2;
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            
            // Count numbers <= mid in each row using binary search
            for (int i = 0; i < m; i++) {
                place += countLessEqual(matrix[i], mid);
            }
            
            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        return min; // min == max
    }
    
    // Helper: counts numbers <= target in a sorted row
    private int countLessEqual(int[] row, int target) {
        int left = 0, right = row.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
