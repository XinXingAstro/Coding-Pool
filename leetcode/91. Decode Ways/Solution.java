public class Solution {
    /**
     * Num decodings int.
     * 带条件判断的爬梯子问题
     * 动态规划算法
     *
     * @param s the s
     * @return the int
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int a = Integer.valueOf(s.substring(i-1, i));
            int b = Integer.valueOf(s.substring(i-2, i));
            if (a >= 1 && a <= 9) dp[i] += dp[i-1];
            if (b >= 10 && b <= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }

    /**
     * Num decodings int.
     * 带条件判断的爬梯子问题
     * 使用三个变量减少空间复杂度。
     *
     * @param s the s
     * @return the int
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int dp1 = 1, dp3 = 0;
        int dp2 = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') dp3 += dp2;
            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7'))
                dp3 += dp1;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = 0;
        }
        return dp2;
    }
}
