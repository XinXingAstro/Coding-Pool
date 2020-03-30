/*
// 使用宽度优先遍历找到迷宫的最短路径

import java.util.*;

public class MazeMinDis {
    public int INF = 100000000;

    // 使用pair表示状态
    Map<Integer, Integer> P;

    // 输入
    char[][] maze; // 表示迷宫的字符串的数组
    int N, M;
    int sx, sy; // 起点坐标
    int gx, gy; // 终点坐标

    int[][] d; // 到各个位置的最短距离的数组

    // 4个方向移动的向量
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    // 求从(sx, sy)到(gx, gy)的最短距离
    // 如果无法到达，则是INF
    public int bfs() {
        P = new HashMap<>();
        Queue<Map<Integer, Integer>> que = new LinkedList<>();
        // 把所有的位置都初始化为INF
        for (int i = 0; i < N; i++)
            for (int j = 0; i < M; j++) d[i][j] = INF;
        // 将起点加入队列，并把这一地点的距离设置为0
        que.offer(P.put(sx, sy));
        d[sx][sy] = 0;

        // 不断循环直到队列的长度为0
        while (!que.isEmpty()) {
            // 从队列的最前端取出元素
            Pair<Integer, Integer> p = que.poll();
            // 如果取出的状态已经是终点，则结束搜索
            if (p.getKey() == gx && p.getValue() == gy) break;

            // 四个方向的循环
            for (int i = 0; i < 4; i++) {
                // 移动之后的位置记为（nx， ny）
                int nx = p.getKey() + dx[i], ny = p.getValue() + dy[i];

                // 判断是否可以移动以及是否已经访问过（d[nx][ny]!=INF即为已经访问过）
                if (0 <= nx && nx <= N && 0 <= ny && ny <= M && maze[nx][ny] != '#' && d[nx][ny] == INF) {
                    // 可以移动的话，则加入到队列，并且到该位置的距离确定为到p的距离+1
                    que.push(new Pair<>(nx, ny));
                    d[nx][ny] = d[p.getKey()][p.getValue()] + 1;
                }
            }
        }
        return d[gx][gy];
    }

    public int solve() {
        return bfs();
    }

 }*/
