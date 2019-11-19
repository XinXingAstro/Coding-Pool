public class Solution {
    /**
     * 顺时针旋转数组
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     * @param matrix the matrix
     */
    public void rotate(int[][] matrix) {
        //矩阵按照中间横轴对换
        int u = 0, d = matrix.length - 1;
        while (u < d) {
            int[] temp = matrix[u];
            matrix[u] = matrix[d];
            matrix[d] = temp;
            u++; d--;
        }
        //矩阵按照主轴线'\'进行对换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
