import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * Subsets with dup list.
     * 经典回溯算法题，模板程序
     *
     * @param nums the nums
     * @return the list
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);//必须要对数组进行排序，否则重复元素可能不在一起
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] a, int start, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < a.length; i++) {
            if (i > start && a[i] == a[i-1]) continue;
            path.add(a[i]);
            backtrack(a, i+1, path, ans);
            path.remove(path.size()-1);
        }
    }
}
