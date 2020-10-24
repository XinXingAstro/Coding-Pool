package Graph;

import java.util.*;

/*
 * 解决：单源最短路径问题
 * Dijkstra算法(使用优先队列)
 * 时间复杂度：O((|E|+|V|)log|V|)
 * 要求：图中没有负边
 */
public class Dijkstra {
    private final int INF = 1000000;
    private List<Edge>[] G; // 邻接表存储图
    private int[] d;

    private void dijkstra(int s) {
        // 堆中存放那int[], o[0]表示最短距离，o[1]表示结点标号，堆按照o[0]从小到大的顺序取出值
        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.fill(d, INF);
        d[s] = 0;
        queue.offer(new int[]{0, s});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int v = cur[1];
            if (d[v] < cur[0]) continue; //因为cur[0]里面记录的可能不是最新的d[v]
            for (Edge e : G[v]) {
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    queue.offer(new int[]{d[e.to], e.to});
                }
            }
        }
    }
}
