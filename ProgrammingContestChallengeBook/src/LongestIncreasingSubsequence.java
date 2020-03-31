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
        System.out.println(new LongestIncreasingSubsequence().solve1());
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

    /*
    * 优化动态规划算法
    * 使用lower_bound函数
    * dp[i]:=长度为i+1的上升子序列中末尾元素的最小值（不存在的话就是INF）
    * 初值：dp[i] = INF
    * dp中大于等于a[i]的最小位置放a[i]，迭代遍历a[i]，dp数组中不为INF的数的长度既为解
    * lower_bound函数使用二分搜索，所以算法整体时间复杂度为：O(nlogn)
    * */
    public int solve1() {
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = 1000010;
        }
        for (int i = 0; i < n; i++) {
            dp[lower_bound(0, n, dp, a[i])] = a[i];
        }
        int res = 0;
        for (int i = 0; i < n+1; i++) {
            if (dp[i] < 1000010) res++;
        }
        return res;
    }
    public int lower_bound(int l, int r, int[] a, int k) {
        while (l <= r) {
            int i = (r + l) / 2;
            if (k > a[i]) l = i + 1;
            else if (k < a[i]) r = i - 1;
            else return i;
        }
        return l;
    }
}
