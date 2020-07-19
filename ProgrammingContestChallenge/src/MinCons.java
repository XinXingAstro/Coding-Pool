/*
// 给定一定面值和数量的硬币，求最少使用多少枚硬币达到指定金额
public class MinCons {
    // 硬币的面值
    public int[] V = {1, 5, 10, 50, 100, 500};

    // 输入
    int[] C = new int[6]; // 记录各种面值硬币的数量
    int A; // 要求达到的金额

    public int solve() {
        int ans = 0;

        for (int i = 5; i >= 0; i--) {
            int t = min(A / V[i], C[i]); // 使用硬币i的枚数
            A -= t * V[i];
            ans += t;
        }

        return ans;
    }
}*/
