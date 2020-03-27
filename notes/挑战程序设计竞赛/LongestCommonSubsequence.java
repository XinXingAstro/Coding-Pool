/*
* 最长公共子序列问题
* 给定两个字符串s和t，求出这两个字符串最长的公共子序列的长度。（这个子序列可以不连续）
* */
import java.util.*;
public class LongestCommonSubsequence {
    public static int n;
    public static int m;
    public static String s;
    public static String t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next();
        t = scanner.next();
        System.out.println(new LongestCommonSubsequence().solve());
    }

    /*
    * 记dp[i][j]表示：s字符串前i个字符和t字符串前j个字符最长公共子序列
    * dp[i][j] = dp[i-1][j-1] + 1 (s[i] != t[j]) 如果两字符相同：dp应为前面计算结果加1。
    * dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) (s[i] == t[j]) 如果两字符不等：dp应为前面计算结果的最大值。
    * */
    public int solve() {
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) != t.charAt(j-1)) {
                    // 如果两个字符不相等
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } else {
                    // 如果两个字符相等
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }

        return dp[n][m];
    }
}
