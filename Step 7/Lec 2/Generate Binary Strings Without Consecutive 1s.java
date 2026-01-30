class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, "", result);
        return result;
    }

    private void backtrack(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        backtrack(n, current + "0", result);
        
        if (current.length() == 0 || current.charAt(current.length() - 1) != '1') {
            backtrack(n, current + "1", result);
        }
    }
}
