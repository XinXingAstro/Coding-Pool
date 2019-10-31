import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length, row=0, col=0;
        boolean[][] used = new boolean[m][n];
        ans.add(matrix[row][col]);
        used[row][col] = true;
        for (int i = 0; i <= (m * n); i++) {
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
