/* 01Knapsack Problem
 * 有哪个重量和价值分别为wi，vi的物品。从这些物品中挑选出总重量不超过W的物品，
 * 求所有挑选方案中价值总和的最大值。
 * Restriction：
 * 1 <= n <= 100
 * 1 <= wi,vi <= 100
 * 1 <= W <= 10000
 * Input:
 * n = 4
 * (w, v) = {(2, 3), (1, 2), (3, 4), (2, 2)}
 * W = 5
 * Output: 
 * 7 (选择第0、1、3号物品)
 */
public class Knapsack_01 {
	private int[][] dp; //dp[i][j]:=从第i个物品开始挑选总重小于j时，总价值的最大值。
	public void init(int[] v, int[] w, int W) {
		dp = new int[v.length + 1][W + 1];
		for (int[] i : dp) Arrays.fill(i, -1);
		int res = 0;
		res = topDownRec(0, W); 
	}
	public int topDownRec(int i, int[] v, int[] w, int W) {
		if (dp[i][W] >= 0) return dp[i][W];
		if (i == v.length) return 0;
		int res = 0;
		if (W < w[i]) res = res(i + 1, W);
		else res = Math.max(res(i + 1, W), res(i + 1, W - w[i]) + v[i]);
		dp[i][W] = res;
		return res;
	}
	public int buttomUpItr(int[] v, int[] w, int W) {
		for (int i = v.length-1; i >= 0; i--) {
			for (int j = 0; j <= W; j++) {
				if (j < w[i]) {
					dp[i][j] = dp[i + 1][j];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
				}
			}
		}
		return dp[0][W];
	}
}
