public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }
        char[] t = sb.toString().toCharArray();
        int[] p = new int[t.length];
        int id = 0, mx = 0, resId = 0, resMx = 0;
        for (int i = 1; i < t.length; ++i) {
            p[i] = mx > i ? Math.min(p[2*id-i], mx-i) : 1;
        }
    }
}