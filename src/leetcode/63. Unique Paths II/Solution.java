public class Solution {
    /**
     * Unique paths with obstacles int.
     * 使用dp[][]辅助数组，如果obstacleGird中某一节点为1，则该点不为后面的点贡献路径数。
     * 可以直接使用obstacleGrid存储路径数，降低空间复杂度。
     *
     * Time complexity：O(m*n)
     * Space complexity: O(m*n)
     *
     * @param obstacleGrid the obstacle grid
     * @return the int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean isOb = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) isOb = true;
            if(!isOb) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        isOb = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) isOb = true;
            if(!isOb) dp[i][0] = 1;
            else dp[i][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1 || (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] ==1))
                    continue;
                if (obstacleGrid[i-1][j] == 0) dp[i][j] += dp[i-1][j];
                if (obstacleGrid[i][j-1] == 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Unique paths with obstacles int.
     * 直接使用obstacleGrid矩阵作为dp矩阵进行运算
     *
     * Time complexity: O(m*n)
     * Space complexity: O(1)
     *
     * @param obstacleGrid the obstacle grid
     * @return the int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = (obstacleGrid[i-1][0] != 0 && obstacleGrid[i][0] == 0) ? 1 : 0;
        for (int i = 1; i < n; i++)
            obstacleGrid[0][i] = (obstacleGrid[0][i-1] != 0 && obstacleGrid[0][i] == 0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
