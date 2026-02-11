class Solution {
    public double myPow(double x, int n) {
        long power = n;        // convert to long to avoid overflow
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            if ((power & 1) == 1) {   // if power is odd
                result *= x;
            }
            x *= x;          // square the base
            power >>= 1;     // divide power by 2
        }

        return result;
    }
}
