import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    /**
     * Backtrack典型算法+used判断
     *
     * @param a    the a
     * @param used the used
     * @param path the path
     * @param ans  the ans
     */
    public void backtrack(int[] a, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == a.length) ans.add(new ArrayList<>(path));
        else {
            for (int i = 0; i < a.length; i++) {
                //如果a[i] == a[i -1]则其中只要有一个用过就跳过循环
                if (used[i] || (i > 0 && a[i] == a[i - 1] && used[i - 1])) continue;
                path.add(a[i]);
                used[i] = true;
                backtrack(a, used, path, ans);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
