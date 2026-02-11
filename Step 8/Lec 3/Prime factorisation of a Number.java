import java.util.*;

class Solution {
    public List<List<Integer>> primeFactors(int[] queries) {
        int n = queries.length;
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Find maximum number in queries
        int max = 0;
        for (int num : queries) {
            max = Math.max(max, num);
        }
        
        // Step 2: Build SPF array
        int[] spf = new int[max + 1];
        
        for (int i = 2; i <= max; i++) {
            spf[i] = i;
        }
        
        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        
        // Step 3: Factorize each query
        for (int num : queries) {
            List<Integer> factors = new ArrayList<>();
            
            while (num > 1) {
                factors.add(spf[num]);
                num /= spf[num];
            }
            
            result.add(factors);
        }
        
        return result;
    }
}
