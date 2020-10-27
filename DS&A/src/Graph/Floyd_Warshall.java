package Graph;

/*
 * 解决：任意两点间最短路径问题
 * Floyd-Warshall算法
 * 时间复杂度：O(|V|^3)
 */
public class Floyd_Warshall {
    private int[][] d; //d[u][v]表示边e=(u, v)的权值（不存在时设为INF，不过d[i][i]=0）
    private int V;     // 顶点数
    
    private void floyd_warshall() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}