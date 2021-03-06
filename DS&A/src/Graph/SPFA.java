package Graph;

import java.util.*;

/*
* 解决：单源最短路径问题
* Shortest Path Faster Algorithm (SPFA) 算法
* 时间复杂度：O(kE)(k为所有顶点进队得平均次数，可以证明k一般<=2, E为图的边数)
* */
public class SPFA {
    private final int INF = 1000000;
    private List<Edge>[] G;
    private int[] d;
    private int V;

    private void spfa(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] inq = new boolean[V];
        Arrays.fill(d, INF);
        d[s] = 0;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            inq[v] = false;
            for (Edge e : G[v]) {
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    if (!inq[e.to]) {
                        queue.offer(e.to);
                        inq[e.to] = true;
                    }
                }
            }
        }
    }
}
