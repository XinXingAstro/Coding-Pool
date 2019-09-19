class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        char[][] map = new char[8][];
        map[0] = "abc".toCharArray();
        map[1] = "def".toCharArray();
        map[2] = "ghi".toCharArray();
        map[3] = "jkl".toCharArray();
        map[4] = "mno".toCharArray();
        map[5] = "pqrs".toCharArray();
        map[6] = "tuv".toCharArray();
        map[7] = "wxyz".toCharArray();
        ans.add("");
        for (char d : digits.toCharArray()) {
            List<String> expand = new ArrayList<>();
            for (char c : map[d - '2']) {
                for (String str : ans) {
                    expand.add(str + c);
                }
            }
            ans = expand;
        }
        return ans;
    }
}