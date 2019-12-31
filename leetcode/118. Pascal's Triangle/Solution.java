import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i-1; j++) {
                List<Integer> preRow = ans.get(i-2);
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            if (i > 1) row.add(1);
            ans.add(row);
        }
        return ans;
    }
}