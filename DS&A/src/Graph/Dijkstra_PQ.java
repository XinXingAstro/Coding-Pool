package Graph;

import java.util.*;

// 优化使用优先队列查找距离最短的结点
public class Dijkstra_PQ {
    // 时间复杂度O(ElogV)
    private class Edge {
        private int to;
        private int cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    private class P {
        private int first;  // first是最短距离
        private int second; // second是顶点编号
        public P(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int MAX_V;
    private int V;
    private List<Edge>[] G = new ArrayList[MAX_V]; // 邻接表存储图
    private int[] d = new int[MAX_V];

    private void dijkstra(int s) {
        // 堆按照first从小到大的顺序取出值
        PriorityQueue<Dijkstra_PQ.P> que = new PriorityQueue(new Comparator<Dijkstra_PQ.P>(){
            @Override
            public int compare(Dijkstra_PQ.P p1, Dijkstra_PQ.P p2) {
                return p1.first - p2.first;
            }
        });
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        que.offer(new Dijkstra_PQ.P(0, s));

        while (!que.isEmpty()) {
            Dijkstra_PQ.P p = que.poll();
            int v = p.second;
            if (d[v] < p.first) continue;
            // 遍历所有和顶点v邻接的边，更新最短距离
            for (int i = 0; i < G[v].size(); i++) {
                Edge e = G[v].get(i);
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    que.offer(new Dijkstra_PQ.P(d[e.to], e.to));
                }
            }
        }
    }
}
