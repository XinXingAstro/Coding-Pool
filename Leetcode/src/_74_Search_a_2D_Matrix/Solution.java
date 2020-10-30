public class Solution {
    /**
     * Search matrix boolean.
     * 由于数组前一行所有元素都比后一行小，所以整个矩阵都可以看成是一个排序的数组，
     * 直接在这个数组上进行二分搜索就可以。
     * 注意：处理异常情况。
     * Time complexity: O(logn)
     * Space complexity: O(1)
     *
     * @param matrix the matrix
     * @param target the target
     * @return the boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid/n][mid%n] == target) return true;
            else if (matrix[mid/n][mid%n] > target) hi = mid - 1;
            else if (matrix[mid/n][mid%n] < target) lo = mid + 1;
        }
        return false;
    }
}
