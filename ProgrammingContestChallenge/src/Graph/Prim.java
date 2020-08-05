public class Prim {
    private int MAX_V; // 最大顶点数
    private int[][] cost = new int[MAX_V][MAX_V]; // cost[u][v]表示边e=(u,v)的权值（不存在的情况下设为INF）
    private int[] mincost = new int [MAX_V]; // 从集合X出发的边道每个顶点的最小权值
    private boolean[] used = new boolean[MAX_V]; // 顶点i是否包含在集合X中
    private int V; // 顶点数

    private int prim() {
        Arrays.fill(mincost, Integer.MAX_VALUE);
        mincost[0] = 0;
        int res = 0;
        while (true) {
            int v = -1;
            // 从不属于X的顶点中选取从X到其权值最小的顶点
            for (int u = 0; u < V; u++) {
                if (!used[u] && (v == -1 || mincost[u] < mincost[v])) v = u;
            }
            if (v == -1) break;
            used[v] = true; // 把顶点v加入X
            res += mincost[v]; // 把边的长度加到结果里
            for (int u = 0; u < V; u++) {
                mincost[u] = Math.min(mincost[u], cost[v][u]);
            }
        }
        return res;
    }
}