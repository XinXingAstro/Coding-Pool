/*
* 多重集组合数
* 有n种物品，第i种物品有ai个，不同种类的物品可以相互区分但相同种类的无法区分，
* 从这些物品中取出m个的话，有多少种取法？求出方案数对M的余数
*
* 限制条件：
* 1 <= n <= 1000
* 1 <= m <= 1000
* 1 <= ai <= 1000
* 2 <= M <= 10000
*
* */
import java.util.*;
public class MultiColCombNum {
    public static int n;
    public static int m;
    public static int M;
    public static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        M = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        System.out.println(new MultiColCombNum().solve());
    }

    /*
    * 推荐阅读：
    * https://www.cnblogs.com/ibilllee/p/9205770.html
    * */
    public int solve() {
        int[][] dp = new int[n+1][m+1];
        // 一个都不取的方法总是只有一种
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 >= a[i]) {
                    // 在有取余的情况下，要避免减法运算的结果出现负数
                    dp[i+1][j] = (dp[i+1][j-1] + dp[i][j] - dp[i][j-1-a[i]] + M) % M;
                } else {
                    dp[i+1][j] = (dp[i+1][j-1] + dp[i][j]) % M;
                }
            }
        }
        return dp[n][m];
    }
}
