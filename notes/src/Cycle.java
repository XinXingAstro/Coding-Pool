// 检测图中是否有环
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i, i);
        }
    }
    // v是从u来的，在无环图中v的所有相邻结点中只有u是marked
    // 如果v的相邻结点中存在marked结点但不是u，则说明有环
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }
}
