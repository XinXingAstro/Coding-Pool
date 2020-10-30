import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 递归法计算全组合，该方法可应用于多道题目
     * 运行时间31ms
     * Time complexity: O(2^n)
     * Space complexiy: O(2^n)
     *
     * @param n the n
     * @param k the k
     * @return the list
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() > k) return;
        if (path.size() == k) ans.add(new ArrayList<>(path));
        else {
            for (int i = start; i <= n; i++) {
                path.add(i);
                backtrack(n, k, i+1, path, ans);
                path.remove(path.size()-1);
            }
        }
    }

    /**
     * 递归法计算全组合，该方法可应用于多道题目
     * 将backtrack中的else语句去掉，将for循环放到外面，
     * 就可以立刻将程序的运行时间降低到8ms很神奇。
     * 运行时间8ms
     * Time complexity: O(2^n)
     * Space complexiy: O(2^n)
     *
     * @param n the n
     * @param k the k
     * @return the list
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() > k) return;
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i+1, path, ans);
            path.remove(path.size()-1);
        }
    }
}
