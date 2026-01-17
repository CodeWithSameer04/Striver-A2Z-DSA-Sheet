class Solution {
    public int findPages(int[] nums, int m) {
        int n = nums.length;
        if (m > n) return -1; // impossible to allocate

        int maxPages = 0;
        int sumPages = 0;
        for (int pages : nums) {
            maxPages = Math.max(maxPages, pages);
            sumPages += pages;
        }

        int low = maxPages;
        int high = sumPages;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(nums, m, mid)) {
                answer = mid;      // feasible, try smaller max
                high = mid - 1;
            } else {
                low = mid + 1;     // not feasible, increase max
            }
        }

        return answer;
    }

    private boolean canAllocate(int[] nums, int m, int maxAllowed) {
        int students = 1;
        int currentSum = 0;

        for (int pages : nums) {
            if (currentSum + pages > maxAllowed) {
                students++;
                currentSum = pages;

                if (students > m) return false;
            } else {
                currentSum += pages;
            }
        }

        return true;
    }
}
