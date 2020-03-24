import java.util.*;

public class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j+1 > i-1 || pal[j+1][i-1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j-1]+1);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = i;
        for (int i = 0; i < n; i++) {
            helper(s, i, i, dp);
            helper(s, i, i+1, dp);
        }
        return dp[n-1];
    }
    private void helper(String s, int l, int r, int[] dp) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (l == 0) dp[r] = 0;
            else dp[r] = Math.min(dp[r], dp[l-1]+1);
            l--; r++;
        }
    }
}