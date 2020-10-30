import java.util.*;

public class Solution {
    /**
     * 暴力搜索法
     * 这种方法形成的递归搜索树的节点数为2^n - 1,
     * 所以时间复杂度为O(2^n)
     * 递归栈的深度为n，所以空间复杂度为O(n)
     *
     * Time complexity: O(2^n)
     * Space complexity: O(n)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 使用备注矩阵进行剪枝
     * memo[i]记录走到第i层台阶时可以reach top的方法数。
     * 递归搜索树的节点数被修剪为n个，因为以步幅为1计算，最多遍历n个节点，
     * 以步幅为2计算，最多遍历n/2个节点。
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    /**
     * @param i    表示目前在第i层
     * @param n    the n
     * @param memo the memo
     * @return the int
     */
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memo[i] > 0) return memo[i];
        memo[i] = climb_Stairs(i+1, n, memo) + climb_Stairs(i+2, n, memo);
        return memo[i];
    }

    /**
     * 动态规划算法
     * 动态规划算法 = 初始条件 + 递推公式；
     * 初始条件：到达第1层台阶只有1种方法dp[1]=1，到达第2层台阶有2种方法dp[2]=2。
     * 递推公式：我们到达第i层台阶时，可以从i-1层到达，也可以从i-2层到达，
     * 所以 dp[i] = dp[i-1] + dp[i-2]
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 如果仔细观察，可以发现上面的动态规划算法的空间复杂度是可以优化的，
     * 而且初始值为1，2，递推公式为dp[i] = dp[i-1] + dp[i-2]正好是Fibonacci数列的递推公式
     * 所以对上面动态规划算法进一步优化得到下面算法。
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * Binets Method
     * |Fn   Fn-1 |     |1   1|
     * |          |  =  |     |的n次方。
     * |Fn-1 Fn-2 |     |1   0|
     * Time complexity: O(logn)
     * Space complexity: O(n)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] retain = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                retain = multiply(retain, a); //如果n为1数，则这里需要补充乘一次a
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return retain;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * Fibonacci 方程直接计算Fn
     * Fn = (1 / sqrt(5)) * (pow((1 + sqrt(5))/2, n) - pow((1 - sqrt(5))/2, n))
     * Time complexity: O(logn)
     * Space complexity: O(1)
     *
     * @param n the n
     * @return the int
     */
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2, n+1) - Math.pow((1-sqrt5)/2, n+1);
        return (int)(fibn/sqrt5);
    }
}
