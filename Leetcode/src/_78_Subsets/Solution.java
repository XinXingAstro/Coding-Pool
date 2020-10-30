import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Subsets list.
     * 经典回溯算法题目
     * Time complexity：O(2^n)
     * Space complexity: O(n)
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] a, int start, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < a.length; i++) {
            path.add(a[i]);
            backtrack(a, i+1, path, ans);
            path.remove(path.size()-1);
        }
    }
}
