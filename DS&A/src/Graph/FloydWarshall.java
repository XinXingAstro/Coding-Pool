package Graph;

/*
 * 求任意两点间的最短距离: Floyd-Warshall算法
 */
public class FloydWarshall {
    // 时间复杂度O(V^3)
    private int MAX_V;                         // 最大顶点数
    private int[][] d = new int[MAX_V][MAX_V]; //d[u][v]表示边e=(u, v)的权值（不存在时设为INF，不过d[i][i]=0）
    private int V;                             // 顶点数
    
    private void warshall_floyd() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}