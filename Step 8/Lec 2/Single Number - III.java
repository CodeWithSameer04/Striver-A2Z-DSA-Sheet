class Solution {    
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        
        // Step 1: XOR all numbers
        for (int num : nums) {
            xorAll ^= num;
        }
        
        // Step 2: rightmost set bit
        int diffBit = xorAll & (-xorAll);
        
        int a = 0, b = 0;
        
        // Step 3: divide into two groups
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        
        // Step 4: return in ascending order
        if (a < b)
            return new int[]{a, b};
        else
            return new int[]{b, a};
    }
}
