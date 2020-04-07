/*
* 图的着色问题
* 概念：把相邻顶点染成不同颜色的问题叫做：图着色问题。
* 对图进行染色所需要的最小颜色数称为：最小着色数。
* 最小着色数是2的图称为：二分图。
*
* 二分图判定
* 限定条件：
* 1 <= n <= 1000
* */
import java.util.*;
public class GraphColoring {
    public static ArrayList<Integer>[] G; // 图
    public static int V;                  // 顶点数
    public static int[] color;            // 顶点i的颜色（1 or -1）

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
    }

    // 把顶点染成1或-1
    public boolean dfs(int v, int c) {
        color[v] = c; // 把顶点v染成颜色c
        for (int i = 0; i < G[v].size(); i++) {
            // 如果相邻的顶点同色，则返回false
            if (color[G[v].get(i)] == c) return false;
            // 如果相邻的顶点还没有被染色，则染成-c
            if (color[G[v].get(i)] == 0 && !dfs(G[v].get(i), -c)) return false;
        }
        // 如果所有顶点都染过色了，返回true
        return true;
    }

    /*
    * 时间复杂度：O(|V|+|E|)
    * */
    public boolean solve() {
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                // 如果顶点i还没有被染色，则染成1
                if (!dfs(i, 1)) return false;
            }
        }
        return true;
    }
}
