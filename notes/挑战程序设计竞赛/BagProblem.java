/*
* 背包问题：
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
public class BagProblem {
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
        dp = new int[n+1][W+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j] = -1;
            }
        }
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = s.nextInt();
            v[i] = s.nextInt();
        }
        System.out.println(new BagProblem().rec(0, W));
    }

    // 从第i个商品开始挑选总重小于j的部分
    public int rec(int i, int j) {
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
}
