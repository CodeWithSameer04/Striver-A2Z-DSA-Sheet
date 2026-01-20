import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : freq.keySet()) {
            int f = freq.get(c);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(c);
        }

        // Step 3: Build result from highest frequency to lowest
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
