/*
* 有一个大小为NxM的院子，雨后计算院子中有多少水洼
* */
public class LakeCounting {
    // 输入
    int N, M;
    char[][] field = new char[MAX_N][MAX_M + 1]; // 园子

    // 现在的位置(x, y)
    public void dfs(int x, int y) {
        // 将现在所在位置替换为'.'
        field[x][y] = '.';

        // 循环遍历移动的8个方向
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // 向x方向移动dx， 向y方向移动dy，移动的结果为（nx, ny)
                int nx = x + dx, ny = y + dy;
                // 判断(nx, ny)是不是在院子内，以及是否有积水
                if (0 <= nx && nx < N && 0 <= ny && ny < M && field[nx][ny] == 'W') dfs(nx, ny);
            }
        }
        return ;
    }

    public int solve() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'W') {
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }
}