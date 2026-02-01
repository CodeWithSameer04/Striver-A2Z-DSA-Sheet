class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, new StringBuilder(), result, map);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current,
                           List<String> result, String[] map) {

        // If one letter chosen for each digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(index + 1, digits, current, result, map);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}
