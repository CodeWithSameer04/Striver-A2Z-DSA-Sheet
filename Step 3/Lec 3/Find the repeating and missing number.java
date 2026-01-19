class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        long sum = 0, sqSum = 0;
        for (int num : nums) {
            sum += num;
            sqSum += (long) num * num;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSqSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long diff = sum - expectedSum;           // A - B
        long sqDiff = sqSum - expectedSqSum;     // A^2 - B^2

        long sumAB = sqDiff / diff;              // A + B

        int A = (int) ((diff + sumAB) / 2);
        int B = (int) (A - diff);

        return new int[]{A, B};
    }
}
