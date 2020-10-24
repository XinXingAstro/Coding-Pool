package Graph;

import java.util.*;

/*
* 解决：单源最短路径问题
* BFS（宽度优先遍历）算法（使用队列）
* 时间复杂度：O(|V|+|E|)(邻接表存储)
*           O(|V|^2)(邻接矩阵存储)
* */
public class BFS_SP {
    private final int INF = 1000000;
    private List<Edge>[] G;
    private int[] d;

    private void bfs_sp(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.fill(d, INF);
        d[s] = 0;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Edge e : G[v]) {
                if (d[e.to] > d[v] + e.cost) {
                    d[e.to] = d[v] + e.cost;
                    queue.offer(e.to);
                }
            }
        }
    }
}
