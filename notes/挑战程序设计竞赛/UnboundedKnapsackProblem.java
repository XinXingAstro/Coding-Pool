/*
* 完全背包问题
* 有n中重量个价值分别为wi，vi的物品。从这些物品中挑选总重量不超过W的物品，
* 求出挑选物品价值总和最大值。在这里，每种物品可以挑选任意多件。
*
* 限制条件：
* 1 <= n < = 100
* 1 <= wi,vi <= 100
* 1 <= W <= 10000
* */
import java.util.*;
public class UnboundedKnapsackProblem {
    public static int n; // 物品个数
    public static int W; // 背包中物品总重最大值
    public static int[] w; // 各物品重量
    public static int[] v; // 各物品价值

    public static int[][] dp; // 记忆化数组

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        W = scanner.nextInt();
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        System.out.println(new UnboundedKnapsackProblem().solve());
        System.out.println(new UnboundedKnapsackProblem().solve1());
        System.out.println(new UnboundedKnapsackProblem().solve2());
        System.out.println(new UnboundedKnapsackProblem().solve3());
    }

    /*
    * 一件物品可以取无限次，内部使用循环确定出最大值。
    * O(nW^2)
    * 可以进一步优化
    * */
    public int solve() {
        dp = new int[n+1][W+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (j < w[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    for (int k = 0; k*w[i-1] <= j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (k * w[i-1])] + k * v[i-1]);
                    }
                }
            }
        }

        return dp[n][W];
    }

    /*
    * 当 j>=w[i] 时：
    * dp[i + 1][j] = max(dp[i][j - k*w[i]] + k*v[i] | k >= 0)
    *              = max(dp[i][j], max(dp[i][j - (k * w[i])] + k * v[i]) | k >= 1)
    *              = max(dp[i][j], max(dp[i][j - k*w[i] - w[i]] + k*v[i] + v[i] | k >= 0))
    *              = max(dp[i][j], dp[i+1][j - w[i]] + v[i])
    * 当j < w[i]时：
    * dp[i + 1][j] = dp[i][j]
    * 时间复杂度：O(nW)
    * */
    public int solve1() {
        dp = new int[n + 1][W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }

        return dp[n][W];
    }

    /*
    * 优化空间复杂度
    * 将dp二维数组降为一维
    * 注意：内部循环的遍历方向必须时从w[i]到W
    * */
    public int solve2() {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= W; j++) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }

        return dp[W];
    }

    /*
    * 优化空间复杂度
    * dp[i + 1][j] = max(dp[i][j], dp[i + 1][j - w[i]] + v[i])
    * dp计算过程中只使用到了dp[i]和dp[i + 1]，所以可以结合奇偶性写成下面这样
    * */
    public int solve3() {
        dp = new int[2][W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[(i + 1) & 1][j] = dp[i & 1][j];
                } else {
                    dp[(i + 1) & 1][j] = Math.max(dp[i & 1][j], dp[(i + 1) & 1][j - w[i]] + v[i]);
                }
            }
        }

        return dp[n & 1][W];
    }
}
