class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Every state is a valid subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Un-choose
            current.remove(current.size() - 1);
        }
    }
}
