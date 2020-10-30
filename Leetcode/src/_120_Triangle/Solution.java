import java.util.*;

public class Solution {
    /**
     * Minimum total int.
     * 动态规划算法，从底向上遍历
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param triangle the triangle
     * @return the int
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size();
        Integer[] pd = triangle.get(row-1).toArray(new Integer[row]);
        for (int r = row-2; r >= 0; r--) {
            List<Integer> cur = triangle.get(r);
            for (int c = 0; c <= r; c++) {
                pd[c] = Math.min(pd[c], pd[c+1]) + cur.get(c);
            }
        }
        return pd[0];
    }
}