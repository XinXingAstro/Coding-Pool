/*
* POJ 1182
* */
import java.util.*;
public class FoodChain {
    public static int N;
    public static int K;
    public static int[] T;
    public static int[] X;
    public static int[] Y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        T = new int[N];
        X = new int[N];
        Y = new int[N];
        for (int i = 0; i < K; i++) {
            T[i] = scanner.nextInt();
            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
        }
        System.out.println(new FoodChain().solve());
    }

    public int solve() {
        // 初始化并查集
        // 元素x, x+N, x+2N分别代表x-A, x-B, x-C
        UnionFind uf = new UnionFind(3 * N);

        int ans = 0;
        for (int i = 0; i < K; i++) {
            int t = T[i];
            int x = X[i]-1, y = Y[i] - 1; // 将输入变成0,...,N-1的范围

            // 不正确的编号
            if (x < 0 || N <= x || y < 0 || N <= y) {
                ans++;
                continue;
            }

            if (t == 1) {
                // "x和y属于同一类“的信息
                if (uf.same(x, y + N) || uf.same(x, y + 2 * N)) {
                    ans++;
                } else {
                    uf.unite(x, y);
                    uf.unite(x + N, y + N);
                    uf.unite(x + N * 2, y + N * 2);
                }
            } else {
                // "x吃y"的信息
                if (uf.same(x, y) || uf.same(x, y + 2 * N)) {
                    ans++;
                } else {
                    uf.unite(x, y + N);
                    uf.unite(x + N, y + 2 * N);
                    uf.unite(x + 2 * N, y);
                }
            }
        }
        return ans;
    }
}
