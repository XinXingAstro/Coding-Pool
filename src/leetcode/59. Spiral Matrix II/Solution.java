public class Solution {
    /**
     * 顺时针旋转输出矩阵，跟54题类似
     *
     * @param n the n
     * @return the int [ ] [ ]
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 1, row = 0, col = 0;
        ans[row][col] = 1;
        //这里特别容易形成死循环，因为i最大值为n*n如果加上=等号就形成了死循环
        while (i < n*n) {
            while (col+1 < n && ans[row][col+1] == 0) {
                col++; i++;
                ans[row][col] = i;
            }
            while (row+1 < n && ans[row+1][col] == 0) {
                row++; i++;
                ans[row][col] = i;
            }
            while (col-1 >= 0 && ans[row][col-1] == 0) {
                col--; i++;
                ans[row][col] = i;
            }
            while (row-1 >= 0 && ans[row-1][col] == 0) {
                row--; i++;
                ans[row][col] = i;
            }
        }
        return ans;
    }
}
