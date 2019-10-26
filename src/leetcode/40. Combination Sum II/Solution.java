public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * Backtrack.
     *
     * @param a      the a
     * @param start  the start
     * @param remain the remain
     * @param path   the path
     * @param ans    the ans
     */
    public void backtrack(int a[], int start, int remain, List<Integer> path, List<List<Integer>> ans) {
        if (remain < 0) return;
        else if (remain == 0) ans.add(new ArrayList<>(path));
        else {
            for (int i = start; i < a.length; i++) {
                if(remain < a[i]) break;
                if (i > start && a[i] == a[i - 1]) continue;//跳过重复数字
                path.add(a[i]);
                backtrack(a, i + 1, remain - a[i], path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
