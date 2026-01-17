class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        
        // Find maximum value in nums
        for (int n : nums) {
            high = Math.max(high, n);
        }
        
        int answer = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(nums, threshold, mid)) {
                answer = mid;      // possible, try smaller divisor
                high = mid - 1;
            } else {
                low = mid + 1;     // not possible, increase divisor
            }
        }
        
        return answer;
    }
    
    private boolean isValid(int[] nums, int threshold, int divisor) {
        long sum = 0;
        
        for (int n : nums) {
            sum += (n + divisor - 1) / divisor; // ceil division
            if (sum > threshold) return false;
        }
        
        return true;
    }
}
