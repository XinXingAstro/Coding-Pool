public class KSum {
    // 输入
    int[] a = new int[MAX_N];
    int n, k;

    // 已经从前i项得到了和sum，然后对于i项之后的进行分支
    boolean dfs(int i, int sum) {
        // 如果前n项都计算过了，则返回sum是否与k相等
        if (i == n) return sum == k;

        // 不加上a[i]的情况
        if (dfs(i + 1, sum)) return true;

        // 加上a[i]的情况
        if (dfs(i + 1, sum + a[i])) return true;

        // 无论是否加上a[i]都不能凑成k就返回false
        return false;
    }

    public boolean solve() {
        if (dfs(0, 0)) return ture;
        else return false;
    }
}