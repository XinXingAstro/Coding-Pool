import java.util.Comparator;

public class Kruskal {
    class edge {
        private int u;
        private int v;
        private int cost;
        public edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    private int MAX_V;
    private edge[] es = new edge[MAX_V];
    private int V, E; // 顶点数和边数

    private int kruskal() {
        Arrays.sort(es, new Comparater<edge>(){
            @Override
            public int compare(edge e1, edge e2) {
                return e1.cost - e2.cost;
            }
        }); // 按照edge.cost的顺序从小到大排列
        init_union_find(V); // 初始化并查集
        int res = 0;
        for (int i = 0; i < E; i++) {
            edge e = es[i];
            if (!same(e.u, e.v)) {
                unite(e.u, e.v);
                res += e.cost;
            }
        }
        return res;
    }
}