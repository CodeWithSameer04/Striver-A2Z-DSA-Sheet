class Solution {
public int floorSqrt(int n) {
    if (n == 0 || n == 1) return n;
    
    int low = 1, high = n, ans = 0;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if ((long) mid * mid == n) {
            return mid; // perfect square
        } else if ((long) mid * mid < n) {
            ans = mid;      // possible answer
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return ans;
}


}
