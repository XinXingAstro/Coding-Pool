package Graph;

import java.util.*;

public class PathRestoration {
    private int INF = 1000000;
    private int V;           // 顶点数
    private int[] prev;      // 最短路上的前趋顶点
    private int[] d;         // 最短距离
    private boolean[] used;
    private int[][] cost;

    // 求从起点s出发到各个顶点的最短距离
    private void dijkstra(int s) {
        Arrays.fill(d, INF);
        Arrays.fill(prev, -1);
        d[s] = 0;

        while (true) {
            int v = -1;
            for (int u = 0; u < V; u++) {
                if (!used[u] && (v == -1 || d[u] < d[v])) v = u;
            }

            if (v == -1) break;
            used[v] = true;
            
            for (int u = 0; u < V; u++) {
                if (d[u] < d[v] + cost[v][u]) {
                    d[u] = d[v] + cost[v][u];
                    prev[u] = v;
                }
            }
        }
    }

    // 到顶点t的最短距离
    private List<Integer> get_path(int t) {
        List<Integer> path = new ArrayList<>();
        // 不断沿着prev[t]走直到t=s
        for (; t != -1; t = prev[t]) path.add(t);
        Collections.reverse(path);
        return path;
    }
}