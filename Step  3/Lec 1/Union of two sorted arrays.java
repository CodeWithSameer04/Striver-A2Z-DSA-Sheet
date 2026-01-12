import java.util.*;

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                add(result, nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                add(result, nums1[i]);
                i++;
            } else {
                add(result, nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            add(result, nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            add(result, nums2[j]);
            j++;
        }

        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }

    private void add(ArrayList<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
            list.add(val);
        }
    }
}
