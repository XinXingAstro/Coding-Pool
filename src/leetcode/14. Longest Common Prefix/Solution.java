class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i = 0;
        for (; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) return strs[j];
                else if (strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}