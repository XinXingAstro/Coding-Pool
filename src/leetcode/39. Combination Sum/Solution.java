import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        search(candidates, 0, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 使用二叉搜索树递归搜索，搜索过程中发现很多多余操作，
     * 可以将数组排序后进行剪枝
     * 运行时间：6ms
     *
     * @param a      the a
     * @param i      the
     * @param sum    the sum
     * @param target the target
     * @param path   the path
     * @param ans    the ans
     */
    public void search(int[] a, int i, int sum, int target, List<Integer> path, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target || i == a.length) {
            return;
        }
        path.add(a[i]);
        sum += (a[i]);
        search(a, i, sum, target, path, ans);
        sum -= path.remove(path.size() - 1);
        search(a, i + 1, sum, target, path, ans);
    }

    /**********************************************
     *
     * 剪枝后的算法
     *
     **********************************************/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, 0, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 将输入数组排序，然后在递归过程中进行条件判断剪枝
     * 运行时间：3ms，时间效率提升一倍。
     *
     * @param a      the a
     * @param i      the
     * @param sum    the sum
     * @param target the target
     * @param path   the path
     * @param ans    the ans
     */
    public void search(int[] a, int i, int sum, int target, List<Integer> path, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target || i >= a.length) {
            return;
        }
        path.add(a[i]);
        sum += (a[i]);
        search(a, i, sum, target, path, ans);
        sum -= path.remove(path.size() - 1);
        // 由于a[i]后面的数都大于a[i]所以如果空位小于a[i]则直接跳过后续遍历
        if (target - sum < a[i]) i = a.length;
        search(a, i + 1, sum, target, path, ans);
    }

    /**********************************************
     *
     * 回溯算法
     *
     **********************************************/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * 回溯算法
     * 使用for循环做游标的移动，
     * 适用性更广，可以解决CombinationSumI、II、III
     * 运行时间: 2ms
     *
     * @param a      the a
     * @param start  the start
     * @param remain the remain
     * @param path   the path
     * @param ans    the ans
     */
    public void backtrack(int[] a, int start, int remain, List<Integer> path, List<List<Integer>> ans) {
        if (remain < 0) return;
        else if (remain == 0) ans.add(new ArrayList<>(path));
        else {
            for (int i = start; i < a.length; i++) {
                if (remain < a[i]) break; //如果remain小于当前数，则不再进行验证
                path.add(a[i]);
                backtrack(a, i, remain - a[i], path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
