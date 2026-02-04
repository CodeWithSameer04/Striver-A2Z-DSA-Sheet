class Solution {
    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(num, target, 0, 0, 0, "");
        return result;
    }

    private void dfs(String num, int target, int index,
                     long value, long prev, String expr) {

        // If we've used all digits
        if (index == num.length()) {
            if (value == target)
                result.add(expr);
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Avoid numbers with leading zeros
            if (i != index && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                // First number (no operator)
                dfs(num, target, i + 1, curr, curr, "" + curr);
            } else {
                dfs(num, target, i + 1,
                        value + curr, curr,
                        expr + "+" + curr);

                dfs(num, target, i + 1,
                        value - curr, -curr,
                        expr + "-" + curr);

                dfs(num, target, i + 1,
                        value - prev + prev * curr,
                        prev * curr,
                        expr + "*" + curr);
            }
        }
    }
}
