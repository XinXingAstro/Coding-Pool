import java.util.Comparator;
import java.util.Map;

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
            for (int u = 0; i < V; u++) {
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

// 优化使用优先队列查找距离最短的结点
class Dijkstra2 {
    // 时间复杂度O(ElogV)
    class edge {
        private int to;
        private int cost;
        public edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    class P {
        private int first;  // first是最短距离
        private int second; // second是顶点编号
        public P(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int MAX_V;
    private int V; 
    private List<edge>[] G = new ArrayList<>[MAX_V]; // 邻接表存储图
    private int[] d = new int[MAX_V];

    private void dijkstra(int s) {
        // 堆按照first从小到大的顺序取出值
        PriorityQueue<P> que = new PriorityQueue(new Comparator<P>(){
            @Override
            public int compare(P p1, P p2) {
                return p1.first - p2.first;
            }
        });
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        que.offer(new P(0, s));

        while (!que.isEmpty()) {
            P p = que.poll();
            int v = p.second;
            if (d[v] < p.first) continue;
            // 遍历所有和顶点v邻接的边，更新最短距离
            for (int i = 0; i < G[v].size(); i++) {
                edge e = G[v][i];
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    que.offer(new P(d[e.to], e.to));
                }
            }
        }
    }
}