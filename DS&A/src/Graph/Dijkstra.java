package Graph;

import java.util.*;

/* 
 * 单元最短路径算法：Dijkstra算法 
 * 相对于Bellman-Ford的O(V*E)的复杂度，Dijkstra算法的复杂度是O(ElogV)，可以更高效地计算最短路的长度。
 * 但是，在图中存在负边的情况下，Dijkstra算法就无法正确求解问题，还是需要使用Bellman-Ford算法。
 */
public class Dijkstra {
    // 时间复杂度O(V^2)
    private int MAX_V;                            // 最大结点数量
    private int[][] cost = new int[MAX_V][MAX_V]; // cost[u][v] 表示边 e =（u，v) 的权值（不存在这条边时设为INF）
    private int[] d = new int[MAX_V];             // 从顶点s出发的最短路径
    private boolean[] used = new boolean[MAX_V];  // 已经使用过的顶点
    private int V;                                // 顶点数

    // 求从顶点s出发到各个顶点的最短距离
    private void dijkstra(int s) {
        Arrays.fill(d, Integer.MAX_VALUE);
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