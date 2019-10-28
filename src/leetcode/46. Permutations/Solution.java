public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }
    /**
     * 输出数组的全排列。
     * 模板代码，背诵
     * 运行时间：1ms
     *
     * @param a    the a
     * @param path the path
     * @param ans  the ans
     */
    public void backtrack(int[] a, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == a.length) ans.add(new ArrayList<>(path));
        else {
            for (int i = 0; i < a.length; i++) {
                if (path.contains(a[i])) continue; //如果路径中包含该数则跳过
                path.add(a[i]);
                backtrack(a, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
