class Solution {
    /**
     * Longest palindrome string.
     * 中心扩散法
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length(), start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
            
        }
        return s.substring(start, end + 1);
    }
    public int expand(String s, int left, int right) {
        int l = left, r = right, n = s.length();
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * Longest palindrome string.
     * 受到第4题的启发，基于Manacher's Alogrithm的中心扩散法
     * 将原字符串的所有切割位置用‘#’填充，
     * 如“abc”填充为"a#b#c",字符串长度变为2N-1，
     * 之后再基于每个切割位置进行中心扩散判断是否是palindrome串，在此过程中找到最长Palindrome串
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] c = s.toCharArray();
        int n = c.length, max = 0, start = 0, end = 0;
        for (int i = 0; i < (2*n-1); ++i) {
            int L = i / 2;
            int R = (i + 1) / 2;
            while (L >= 0 && R < n && c[L--] == c[R++]) {
                if ((R > L) && ((R-L-2) > max)) {
                    max = R - L - 2;
                    start = L + 1;
                    end = R - 1;
                }
            }
        }
        return s.substring(start, end+1);
    }
}