package Graph;
import java.util.*;
/* 图的着色问题：二分图判定
 * 给定一个具有n个顶点的图。要给图上每个顶点染色，并且要使相邻的顶点颜色不同。
 * 问是否能最多用2种颜色进行染色？题目保证没有重边和自环
 * 
 * 限制条件：
 * 1 <= n <= 1000
 */
public class GraphColor {
    private List<Integer>[] G; // 图
    private int V;             // 顶点数
    private int[] color;       // 顶点i的颜色（1 or -1）

    private boolean dfs(int v, int c) {
        color[v] = c; // 把顶点v山城颜色c
        for (int i = 0; i < G[v].size(); i++) {
            // 如果相邻的顶点同色，则返回false
            if (color[G[v].get(i)] == c) return false;
            // 如果相邻的顶点还没被染色，则染成-c
            if (color[G[v].get(i)] == 0 && !dfs(G[v].get(i), -c)) return false;
        }
        // 如果所有顶点都染过色了，则返回true
        return true;
    }

    private void solve() {
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                // 如果顶点i还没有被染色，则染成1
                if (!dfs(i, 1)) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}