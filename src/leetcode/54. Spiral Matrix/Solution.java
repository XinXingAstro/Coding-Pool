import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Spiral order list.
     * 使用used矩阵记录每个元素是否访问过，while+条件判断转变方向
     *
     * @param matrix the matrix
     * @return the list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length, i=0, row=0, col=0;
        boolean[][] used = new boolean[m][n];
        ans.add(matrix[row][col]);
        used[row][col] = true;
        while (i < (m * n - 1)) {
            while (col+1 < n && !used[row][col+1]) {
                col++;
                ans.add(matrix[row][col]);
                used[row][col] = true;
                i++;
            }
            while (row+1 < m && !used[row+1][col]) {
                row++;
                ans.add(matrix[row][col]);
                used[row][col] = true;
                i++;
            }
            while (col-1 >= 0 && !used[row][col-1]) {
                col--;
                ans.add(matrix[row][col]);
                used[row][col] = true;
                i++;
            }
            while (row-1 >= 0 && !used[row-1][col]) {
                row--;
                ans.add(matrix[row][col]);
                used[row][col] = true;
                i++;
            }
        }
        return ans;
    }
}
