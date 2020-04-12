/*
import javafx.util.Pair;

import java.util.Arrays;

// 区间调度问题，最多能参加几项工作
public class IntervalProblem {
    public static int MAX_N = 100000;
    // 输入
    public static int N; // 表示工作数量
    public static int[] S = new int[MAX_N]; // 表示工作开始时间
    public static int[] T = new int[MAX_N]; // 表示工作结束时间

    //用于对工作排序的pair数组
    public static Pair<Integer, Integer>[] itv = new Pair[MAX_N];

    public int solve() {
        // 对pair进行的是字典序比较
        // 为了让结束时间早的工作排在前面，把T存入Key，把S存入Value
        for (int i = 0; i < N; i++) {
            itv[i] = new Pair<Integer, Integer>(T[i], S[i]);
        }
        Arrays.sort(itv);

        // t是最后所选的工作的结束时间
        int ans = 0, t = 0;
        for (int i = 0; i < N; i++) {
            if (t < itv[i].getValue()) {
                ans++;
                t = itv[i].getKey();
            }
        }
        return ans;
    }
}
*/
