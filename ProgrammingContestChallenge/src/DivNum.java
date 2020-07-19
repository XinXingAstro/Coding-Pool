/*
* 划分数问题
* 有n个无区别的物品，将他们划分成不超过m组，求出划分方法数对M的余数。
*
* 限制条件：
* 1 <= m <= n <= 1000
* 2 <= M <= 10000
*
* */
import java.util.*;
public class DivNum {
    public static int n;
    public static int m;
    public static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        M = scanner.nextInt();
        System.out.println(new DivNum().solve());
    }

    /*
    * 动态规划算法
    * dp[i][j]:=j的i划分的总数。
    * 对于n的m划分ai，如果对于每个ai>0，那么{ai-1}就对应了n-m的m划分，
    * 如果存在ai=0，那么就对应了n的m-1划分，所以有如下对推关系：
    * dp[i][j] = dp[i][j-i] + dp[i-1][j]
    * 时间复杂度O(nm)
    * */
    public int solve(){
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-i]) % M;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
