import java.util.*;

public class Solution {
    /**
     * Gets row.
     * 直接在一个数组上进行相加计算
     * Time complexity: O(K)
     * Space complexity: O(N)
     *
     * @param rowIndex the row index
     * @return the row
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex < 0) return row;
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(i, 1);
            for (int j = i-1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j-1));
            }
        }
        return row;
    }
}