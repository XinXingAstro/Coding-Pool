/*
* 0-1背包问题：
* 有n个重量个价值分别是Wi和Vi的物品，从这些物品中挑选出总重量不超过W的物品，
* 求所有挑选的方案中价值总和的最大值。
*
* 限制条件：
* 1 <= n <= 100
* 1 <= wi,vi <= 100
* 1 <= W <= 1000
*
* */
import java.util.*;
public class BoundedKnapsackProblem1 {
    // 记忆化数组
    public static int[][] dp;

    public static int n;
    public static int W;
    public static int[] w;
    public static int[] v;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        W = s.nextInt();
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = s.nextInt();
            v[i] = s.nextInt();
        }
        System.out.println(new BoundedKnapsackProblem1().rec(0, W));
        System.out.println(new BoundedKnapsackProblem1().recIteration());
        System.out.println(new BoundedKnapsackProblem1().recIteration1());
        System.out.println(new BoundedKnapsackProblem1().recIteration2());
    }

    /*
     * 背包问题的递归解决方法O(nW)
     * 记dp[i][j]表示：从第i个物品开始挑选总重小于j时，总价值的最大值
    **/
    public int rec(int i, int j) {
        // 初始化dp数组
        dp = new int[n+1][W+1];
        for (int r = 0; r < n+1; r++) {
            for (int c = 0; c < W+1; c++) {
                dp[r][c] = -1;
            }
        }

        if (dp[i][j] >= 0) {
            // 如果已经计算过就直接使用之前的结果
            return dp[i][j];
        }
        int profit;
        if (i == n) {
            // 已经没有剩余物品了
            profit = 0;
        } else if (j < w[i]) {
            // 无法挑选这个物品
            profit = rec(i+1, j);
        } else {
            // 挑选和不挑选的两种情况都尝试一下
            profit = Math.max(rec(i+1, j), rec(i+1, j-w[i])+v[i]);
        }
        // 将结果记录在数组中
        return dp[i][j] = profit;
    }

    /*
    * 背包问题的迭代解决方法O(nW)
    * 记dp[i][j]表示：从第i个商品开始挑选总重小于j时，总价值的最大值
    * 初值：dp[n][j] = 0 没有商品了
    * dp[i][j] = dp[i+1][j]  (j < w[i] 剩余重量小于w[i])
    * dp[i][j] = max(dp[i+1][j], dp[i+1][j-w[i]]+v[i]) (选或不选i的最大值)
    * */
    public int recIteration() {
        dp = new int[n+1][W+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i+1][j];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-w[i]]+v[i]);
                }
            }
        }
        return dp[0][W];
    }

    /*
    * 背包问题迭代解决方法O(nW)
    * 记dp[i][j]表示；从前i个商品中选出总重量不超过j的物品时总价值的最大值
    * 初值：dp[0][j] = 0 没有物品可选
    * dp[i+1][j] = dp[i][j]  (j < w[i]第i个物品的重量超过j无法选择)
    * dp[i+1][j] = max(dp[i][j], dp[i][j-w[i]]+v[i]) (选择第i个物品或者不选第i个物品获得价值的最大值)
    * */
    public int recIteration1() {
        dp = new int[n+1][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-w[i]] + v[i]);
                }
            }
        }
        return dp[n][W];
    }

    /*
    * 优化空间复杂度
    * 将dp二维数组降为一维
    * 注意：内部循环的遍历方向必须是从W到w[i]
    * */
    public int recIteration2() {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[W];
    }
}
