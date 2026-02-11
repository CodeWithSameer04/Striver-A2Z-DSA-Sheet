import java.util.*;

class Solution {
    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                
                if (i != n / i) {  // Avoid duplicate for perfect square
                    list.add(n / i);
                }
            }
        }
        
        // Sort the divisors
        Collections.sort(list);
        
        // Convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
