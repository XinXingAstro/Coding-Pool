public class Solution {
    /**
     * Unique paths int.
     * 动态规划算法的经典题目。
     * 动态规划 = 初始条件 + 递推公式。
     * 动态规划算法的优化主要是空间复杂度的优化。
     * 我们使用dp[i][j]表示robot到达（i, j)点的所有路径，由于robot只能向右或向下移动，
     * 所以到达（i, j）点只能从上面来或者从左边来，所以得到递推公式：
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 由于第1行和第1列上的点只有一条路径可以到达，所以得到初始条件：
     * dp[0][j] = dp[i][0] = 1
     *
     * Time complexity: O(m*n)
     * Space complexity: O(m*n)
     *
     * @param m the m
     * @param n the n
     * @return the int
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始条件
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        //递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Unique paths 1 int.
     * 优化一：由于dp[i][j] = dp[i-1][j] + dp[i][j-1]，
     * 既每一个dp[i][j]都是通过第i行(dp[i][j-1])和第i-1行(dp[i-1][j])得到的
     * 可以用两个数组分别保存第i行和第i-1行的数
     *
     * Time complexity: O(m*n)
     * Space complexity: O(n)
     *
     * @param m the m
     * @param n the n
     * @return the int
     */
    public int uniquePaths_I(int m, int n) {
        int[] cur = new int[n];
        int[] pre = new int[n];
        cur[0] = pre[0] = 1;
        for (int i = 0; i < n; i++) pre[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j =1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            int[] temp = cur;
            cur = pre;
            pre = temp;
        }
        return pre[n-1];
    }

    /**
     * Unique paths ii int.
     * 优化二：通过观察，可以直接在cur当前行更新数据，进一步降低空间复杂度。
     *
     * Time compelexity：O(m*n)
     * Spcae complexity: O(n)
     *
     * @param m the m
     * @param n the n
     * @return the int
     */
    public int uniquePaths_II(int m, int n) {
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) cur[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j] + cur[j-1];
            }
        }
        return cur[n-1];
    }
}
