// 图的宽度优先遍历
public class BreadthFirstPaths {
    private boolean[] marked; 

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Deque<>();
        marked[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[W]) {
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }
}
