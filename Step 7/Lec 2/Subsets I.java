class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        dfs(0, 0, nums, result);
        return result;
    }

    private void dfs(int index, int sum, int[] nums, List<Integer> result) {
        if (index == nums.length) {
            result.add(sum);
            return;
        }

        // Include current element
        dfs(index + 1, sum + nums[index], nums, result);

        // Exclude current element
        dfs(index + 1, sum, nums, result);
    }
}
