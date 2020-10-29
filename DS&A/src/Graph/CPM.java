package Graph;

import java.util.*;

/*
* 解决：优先级限制下的并行任务调度问题
* Critical path method (CPM) 关键路径算法
* 时间复杂度：O(|E|+|V|)
* */
public class CPM {
    private int n;          //任务个数
    private List<Edge>[] G; //图
    private int[] indegree; //每个结点的入度
    private int[] duration; //每个任务的持续时间
    private List<Integer> precedent[]; //任务i必须在precedent[i]之前完成
    private int[] distTo;
    private Edge[] edgeTo;
    private final int NEGATIVE_INF = -1000000;
    private boolean[] marked;
    private Deque<Integer> topologicalOrder;

    private void cpm() {
        int source = 2 * n;      //总开始结点
        int sink = 2 * n + 1;    //总结束结点
        G = new List[2 * n + 2]; //一共需要2n+2个结点（一个总开始source,一个总结束sink，每个任务一个开始i,一个结束i+n）
        for (int i = 0; i < n; i++) {
            G[source].add(new Edge(source, i, 0));
            indegree[i]++;
            G[i + n].add(new Edge(i + n, sink, 0));
            indegree[sink]++;
            G[i].add(new Edge(i, i + n, duration[i]));
            indegree[i + n]++;

            // precedence constraints
            for (int pre : precedent[i]) {
                G[i + n].add(new Edge(i + n, pre, 0));
                indegree[pre]++;
            }
        }

        // compute longest path
        acyclicLP(source);
    }

    private void acyclicLP(int s) {
        distTo = new int[2 * n + 2];
        edgeTo = new Edge[2 * n + 2];
        marked = new boolean[2 * n + 2];
        topologicalOrder = new LinkedList<>();

        Arrays.fill(distTo, NEGATIVE_INF);
        distTo[s] = 0;

        // relax vertices in topological order
        for (int v = 0; v < (2 * n + 2); v++) {
            if (!marked[v]) dfs(v);
        }
        for (int v : topologicalOrder) {
            for (Edge e : G[v]) {
                // relax(e)
                int w = e.to;
                if (distTo[w] < distTo[v] + e.cost) {
                    distTo[w] = distTo[v] + e.cost;
                    edgeTo[w] = e;
                }
            }
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        for (Edge e : G[v]) {
            if (!marked[e.to]) {
                dfs(e.to);
            }
        }
        topologicalOrder.push(v);
    }


}
