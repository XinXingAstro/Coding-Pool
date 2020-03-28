/*
* 0-1背包问题2
* 有n个重量和价值分别为wi，vi的物品。从这些物品中挑选总重量不超过W的物品，
* 求所有挑选方案中价值总和的最大值。
*
* 限制条件：
* 1 <= n <= 100
* 1 <= wi <= 10^7
* 1 <= vi <= 100
* 1 <= W <= 10^9
* */
import java.util.*;
public class BoundedKnapsackProblem2 {
    public static int n;
    public static long W;
    public static long[] w;
    public static int[] v;
    public static long[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        W = scanner.nextLong();
        w = new long[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextLong();
            v[i] = scanner.nextInt();
        }
        System.out.println(new BoundedKnapsackProblem2().solve());
    }

    /*
    * 以n和w作为变量时程序的时间复杂度为O(nW),由于目前W的数量级已经超过10^6,
    * 所以要以n和v作为变量以降低程序的时间复杂度。
    * 定义dp[i+1][j]:=从前i个物品中选出总价值为j时的物品的最小重量（不存在时就是一个充分大的数INF）
    * 初值：dp[0][0] = 0，dp[0][j] = INF
    * dp[i+1][j] = Math.min(dp[i][j], dp[i][j - v[i]] + w[i])
    * 其中dp[i][j]表示不选低i件商品，既从前i-1件商品中选出总价和为j的商品。
    * dp[i][j - v[i]] + w[i]表示选择低i件商品，既从前i-1件商品中选出总价和为j-v[i]的商品，然后选择第i件商品使总价和为j。
    * 时间复杂度就成了O(nMAX_V)
    * */
    public int solve() {
        // 找到最大的MAX_V
        int MAX_V = 0;
        for (int i = 0; i < v.length; i++) {
            MAX_V = Math.max(MAX_V, v[i]);
        }
        // 定义并初始化dp数组
        dp = new long[n + 1][n * MAX_V + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n * MAX_V + 1; j++) {
                dp[i][j] = 1000000010; // 这里不能设置为Long.MAX_VALUE因为后面+w[i]时有可能会越界导致dp成为负值，所以最好是Ｗ的最大值再加一点。
            }
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * MAX_V; j++) {
                if (j < v[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n * MAX_V; i++) {
            if (dp[n][i] <= W) res = i;
        }
        return res;
    }
}
