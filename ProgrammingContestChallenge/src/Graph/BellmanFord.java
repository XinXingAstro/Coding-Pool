/*
 * 单源最短路径问题 
 * Bellman-Ford 算法
 * 记从起点s出发到顶点i的最短距离为d[i]。则下述等式成立：
 * d[i] = min{d[j] + (从j到i的边的权值)|e = (j, i)属于E}
 * 时间复杂度：O(|V|*|E|)
 */
public class BellmanFord {
    // 从顶点from指向顶点to得权值为cost的边
    private class edge {
        private int from;
        private int to;
        private int cost;
    }

    private int MAX_E; // 最大的边数
    private int MAX_V; // 最大的顶点数
    private edge[] es = new edge[MAX_E]; // 边
    private int[] d = new int[MAX_V];    // 最短距离
    private int V, E;  // V是顶点数，E是边数

    // 求解从顶点s出发到所有点的最短距离
    private void shortest_path(int s) {
        for (int i = 0; i < V; i++) d[i] = INF;
        d[s] = 0;
        while (true) {
            boolean update = false;
            for (int i = 0; i < E; i++) {
                edge e = es[i];
                if (d[e.from] != INF && d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    update = true;
                }
            }
            if (!update) break;
        }
    }

    // 如果返回true则存在负圈
    private boolean find_negative_loop() {
        // 将d[i]全部置为0

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                edge e = es[j];
                if (d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;

                    // 如果第n次仍然更新了，则存在负圈
                    if (i == V - 1) return true;
                }
            }
        }
        return false;
    }
}