package Graph;

import java.util.*;

/*
 * 解决：单源最短路径问题
 * Dijkstra算法(使用优先队列)
 * 时间复杂度：O(|E|log|V|)
 * 要求：图中没有负边
 */
public class Dijkstra_PQ {
    private class Edge {
        private int to;
        private int cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private final int INF = 1000000;
    private List<Edge>[] G; // 邻接表存储图
    private int[] d;

    private void dijkstra(int s) {
        // 堆中存放那int[], o[0]表示最短距离，o[1]表示结点标号，堆按照o[0]从小到大的顺序取出值
        PriorityQueue<int[]> que = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.fill(d, INF);
        d[s] = 0;
        que.offer(new int[]{0, s});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int v = cur[1];
            if (d[v] < cur[0]) continue;
            // 遍历所有和顶点v邻接的边，更新最短距离
            for (Edge e : G[v]) {
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    que.offer(new int[]{d[e.to], e.to});
                }
            }
        }
    }
}
