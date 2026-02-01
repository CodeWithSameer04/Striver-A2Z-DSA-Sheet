class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int remainingSum,
                           List<Integer> current, List<List<Integer>> result) {

        // If combination size reaches k
        if (current.size() == k) {
            if (remainingSum == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {

            // Prune if sum goes negative
            if (i > remainingSum) break;

            current.add(i);
            backtrack(i + 1, k, remainingSum - i, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
