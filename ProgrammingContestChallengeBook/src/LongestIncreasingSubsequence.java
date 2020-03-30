/*
* 最长上升子序列问题
* 有一个长为n的数列a0,a1,...,an-1.请求出这个序列中最长的上升子序列的长度。
* 上升子序列指的是对于任意的i < j都满足ai < aj的子序列。
* 限制条件：
* 1 <= n <= 1000
* 0 <= ai <= 1000000
* */
import java.util.*;
public class LongestIncreasingSubsequence {
    public static int n;
    public static int[] a;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(new LongestIncreasingSubsequence().solve());
    }

    /*
    * 动态规划算法
    * dp[i]:=以ai为末尾的最长上升子序列的长度
    * 初值：dp[0] = 0;
    * dp[i] = max|1, 只包含ai的子序列
    *            |dp[j] + 1, j<i且a[j]<a[i]
    * 时间复杂度：O(n^2)
    * */
    public int solve() {
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
