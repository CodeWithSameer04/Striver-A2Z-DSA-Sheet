class Solution {
    public int findRangeXOR(int l, int r) {
        return xor(r) ^ xor(l - 1);
    }

    private int xor(int n) {
        if (n < 0) return 0;

        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            case 3: return 0;
        }
        return 0; // unreachable
    }
}
