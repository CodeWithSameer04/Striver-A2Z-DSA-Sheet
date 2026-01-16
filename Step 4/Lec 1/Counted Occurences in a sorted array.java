import java.util.*;

class Solution {
    public int countOccurrences(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.getOrDefault(target, 0);
    }
}
