import java.util.*;

public class Solution {
    /**
     * Sets zeroes.
     * 先找出哪些行、列应该为0，再分别设置这些行列为0。
     * Time complexity: O(m * n)
     * Space complexity: O(m + n)
     *
     * @param matrix the matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        //先得到哪些行，哪些列应该为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!row.contains(i)) row.add(i);
                    if (!col.contains(j)) col.add(j);
                }
            }
        }
        //然后再分别将这些行 列置0
        for (int r : row) {
            for (int i = 0; i < n; i++) matrix[r][i] = 0;
        }
        for (int c : col) {
            for (int i = 0; i < m; i++) matrix[i][c] = 0;
        }
    }
}
