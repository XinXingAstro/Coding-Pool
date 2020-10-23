package Graph;

import java.util.*;

/* 
 * 解决：单源最短路径问题
 * Dijkstra算法
 * 时间复杂度：O(|V|^2)
 * 要求：图中没有负边
 */
public class Dijkstra {
    private final int INF = 1000000;
    private int V;          // 顶点数
    private int[][] cost;   // cost[u][v] 表示边 e =（u，v) 的权值（不存在这条边时设为INF）
    private int[] d;        // 从顶点s出发的最短路径
    private boolean[] used; // 已经使用过的顶点

    // 求从顶点s出发到各个顶点的最短距离
    private void dijkstra(int s) {
        Arrays.fill(d, INF);
        d[s] = 0;

        while (true) {
            int v = -1;
            // 从尚未使用过的顶点中选择一个距离最小的顶点
            for (int u = 0; u < V; u++) {
                if (!used[u] && (v == -1 || d[u] < d[v])) v = u;
            }

            if (v == -1) break;
            used[v] = true;

            for (int u = 0; u < V; u++) {
                d[u] = Math.min(d[u], d[v] + cost[v][u]);
            }
        }
    }
}