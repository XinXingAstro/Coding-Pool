package Graph;

import java.util.Arrays;

/*
 * 解决：单源最短路径问题
 * Bellman-Ford 算法
 * 时间复杂度：O(|V|*|E|)
 */
public class Bellman_Ford {
    private final int INF = 1000000;

    private class Edge {
        private int from;
        private int to;
        private int cost;
        public Edge(int f, int t, int c) {
            from = f;
            to = t;
            cost = t;
        }
    }

    private int MAX_E; // 最大的边数
    private int MAX_V; // 最大的顶点数
    private Edge[] es; // 边
    private int[] d;   // 最短距离
    private int V, E;  // V是顶点数，E是边数

    // 求解从顶点s出发到所有点的最短距离
    private void shortest_path(int s) {
        for (int i = 0; i < V; i++) d[i] = INF;
        d[s] = 0;
        while (true) {
            boolean update = false;
            for (Edge e : es) {
                if (d[e.from] != INF && d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    update = true;
                }
            }
            if (!update) break;
        }
    }
    // 另一种写法
    private void shortest_path_1(int s) {
        Arrays.fill(d, INF);
        d[s] = 0;
        boolean update = false;
        do {
            update = false;
            for (Edge e : es) {
                if (d[e.from] != INF && d[e.to] > d[e.from] + e.cost) {
                    d[e.to] = d[e.from] + e.cost;
                    update = true;
                }
            }
        } while (update);
    }

    // 如果返回true则存在负圈
    private boolean find_negative_loop() {
        Arrays.fill(d, 0);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                Edge e = es[j];
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