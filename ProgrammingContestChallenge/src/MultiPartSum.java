/*
* 多重部分和问题
* 有n中不同大小的数字ai，每种个mi个。判断是否可以从这些数字之中选出若干使他们的和恰好为K
*
* 限制条件：
* 1 <= n <= 100
* 1 <= ai,mi <= 100000
* 1 <= K <= 100000
* */
import java.util.*;
public class MultiPartSum {
    public static int n;
    public static int K;
    public static int[] a;
    public static int[] m;
    public boolean[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        K = scanner.nextInt();
        a = new int[n];
        m = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            m[i] = scanner.nextInt();
        }
        System.out.println(new MultiPartSum().solve());
        System.out.println(new MultiPartSum().solve1());
    }

    /*
    * 动态规划算法
    * dp[i + 1][j] := 从前i个数组中是否能找到加和为j。
    * 初值：dp[0][0] = true;
    * dp[i + 1][j] |= dp[i][j - k * a[i]] 0 <= k <= mi && k * ai <= j
    * 时间复杂度：O(K * (m1 + m2 + ... + mn)
    * */
    public boolean solve() {
        dp = new boolean[n + 1][K + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= K; j++) {
                for (int k = 0; k <= m[i] && k*a[i] <= j; k++) {
                    dp[i + 1][j] |= dp[i][j - k * a[i]];
                }
            }
        }

        return dp[n][K];
    }

    /*
    * 优化时间复杂度
    * dp[i + 1][j] := 用前i种数加和得到j时第i种数最多能剩余多少个（不能加和得到j的情况下为-1）
    * 初值：dp[0][0] = 0, 其余都为-1
    *                |mi (dp[i][j] >= 0)前i-1个数加个可以得到j，所以第i个数最多还剩mi个
    * dp[i + 1][j] = |-1 (j < ai 或 dp[i + 1][j - ai] <= 0:剩下的空位小于ai,或者前i个数也无法加到j-ai)
    *                |dp[i + 1][j - ai] - 1 (加上1个ai正好可以得到j)
    * 时间复杂度：O(nK)
    * */
    public boolean solve1() {
        int[] dp = new int[K + 1];
        for (int i = 0; i < K; i++) dp[i] = -1;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[j] >= 0) {
                    dp[j] = m[i];
                } else if (j < a[i] || dp[j - a[i]] <= 0) {
                    dp[j] = -1;
                } else {
                    dp[j] = dp[j - a[i]] - 1;
                }
            }
        }
        if (dp[K] >= 0) return true;
        else return false;
    }
}
