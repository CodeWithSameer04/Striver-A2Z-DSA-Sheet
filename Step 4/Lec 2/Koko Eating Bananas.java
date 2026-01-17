class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Find maximum pile
        for (int p : piles) {
            high = Math.max(high, p);
        }
        
        int answer = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatAll(piles, h, mid)) {
                answer = mid;      // possible, try smaller speed
                high = mid - 1;
            } else {
                low = mid + 1;     // not possible, increase speed
            }
        }
        
        return answer;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        long hours = 0;
        
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p / k)
            if (hours > h) return false;
        }
        
        return true;
    }
}
