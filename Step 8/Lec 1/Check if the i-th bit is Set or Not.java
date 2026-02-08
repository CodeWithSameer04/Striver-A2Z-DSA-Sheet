class Solution {
    public boolean checkIthBit(int n, int i) {
        // Your code goes here
        return (n & (1 << i)) != 0;
    }
}