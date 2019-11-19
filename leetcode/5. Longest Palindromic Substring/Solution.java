class Solution {
    //Expand Around Center
    //Time complexity: O(n^2).
    //Space complexity: O(1).
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

    //Manacher's Algorithm
}