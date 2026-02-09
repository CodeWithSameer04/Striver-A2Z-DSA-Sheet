class Solution {
    public int countSetBits(int n) {
        // Your code goes here
        int count = 0;

        while (n > 0) {
            count += (n & 1); // check last bit
            n >>= 1;          // shift right
        }

        return count;
    }
}