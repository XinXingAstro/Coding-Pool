import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Gets permutation.
     * 回溯算法，从小到大逐个找出排列，直到找到第k个后返回。
     * 运行时间：1068ms
     *
     * @param n the n
     * @param k the k
     * @return the permutation
     */
    private int K;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<Integer> ans = new ArrayList<>();
        K = k;
        backtrack(nums, ans);
        String str = "";
        for (int i : ans) str += i;
        return str;
    }
    public void backtrack(int[] a, List<Integer> path) {
        if (path.size() == a.length) {
            K--;
            if (K == 0) {
                return;
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                if (path.contains(a[i])) continue;
                path.add(a[i]);
                backtrack(a, path);
                if (K == 0) return;
                path.remove(path.size() - 1);
            }
        }
    }
    /**
     * Gets permutation.
     * (1,2,3,4)!可以表示为：
     * 1 + (2,3,4)!
     * 2 + (1,3,4)!
     * 3 + (1,2,5)!
     * 4 + (1,2,3)!
     * 假如求第k=15个数(从第0个开始),则这个数应该在第2组(从第0组开始),既第index = k / (n-1)!组中,第一个数3就可以确定。
     * 这时k = k - (index * (n-1)!) = 15 - (2 * 6) = 3
     * (1,2,5)!可以表示为：
     * 1 + (2,5)!
     * 2 + (1,5)!
     * 5 + (1,2)!
     * index = k / (n - 2)! = 3 / 2 = 1; 第二个数2就可以确定。
     * k = k - (index * (n - 2)!) = 3 - (1 * 2) = 1
     * (1,5)!可以表示为：
     * 1 + (5)!
     * 5 + (1)!
     * index = k / (n - 3)! = 1 / 1 = 1; 第三个数5就可以确定。
     * k = k - (index * (n - 3)!) = 1 - (1 * 1) = 0;
     * (1)!可以表示为：
     * 1
     * index = k / (n - 4)! = 0; 第四个数1就可以确定。
     *
     * 运行时间：1ms
     *
     *
     * @param n the n
     * @param k the k
     * @return the permutation
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }
        k -= 1;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = k / fact;
            sb.append(String.valueOf(list.remove(index)));
            k -= index * fact;
        }
        return sb.toString();
    }
}
