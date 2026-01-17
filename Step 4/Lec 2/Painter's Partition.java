class Solution {
    private static final int MOD = 10000003;

    public int paint(int A, int B, int[] C) {
        int n = C.length;
        long low = 0;
        long high = 0;
        int maxBoard = 0;

        for (int len : C) {
            high += len;
            maxBoard = Math.max(maxBoard, len);
        }

        low = maxBoard;  // at least one painter must paint the largest board

        long answer = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPaint(C, A, mid)) {
                answer = mid;
                high = mid - 1;  // try smaller time
            } else {
                low = mid + 1;   // increase time
            }
        }

        // Multiply by B (time per unit) and take modulo
        return (int) ((answer * (long) B) % MOD);
    }

    private boolean canPaint(int[] C, int painters, long maxTime) {
        int requiredPainters = 1;
        long currentSum = 0;

        for (int len : C) {
            if (currentSum + len > maxTime) {
                requiredPainters++;
                currentSum = len;
                if (requiredPainters > painters) return false;
            } else {
                currentSum += len;
            }
        }

        return true;
    }
}
