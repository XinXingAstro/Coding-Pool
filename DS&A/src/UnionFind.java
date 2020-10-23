/*
* 并查集
* */
public class UnionFind {
    private int[] par;  // 父节点
    private int[] rank; // 树的高度

    // 初始化n个元素
    public UnionFind(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // 查询树的根
    public int findRoot(int x) {
        if (par[x] == x) {
            return x;
        } else {
            return par[x] = findRoot(par[x]);
        }
    }

    // 合并x和y所属的集合
    public void unite(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);
        if (x == y) return;

        if (rank[x] < rank[y]) {
            par[x] = y;
        } else {
            par[y] = x;
            if (rank[x] == rank[y]) rank[x]++;
        }
    }

    // 判断x和y是否属于同一个集合
    public boolean same(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}
