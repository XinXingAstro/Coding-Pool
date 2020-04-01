/*
* POJ2431
* */
import java.util.*;
public class Expedition {
    public static int N; // N个加油站
    public static int L; // 卡车需要行驶的距离
    public static int P; // 卡车里面初始燃油量
    public static int[] A; // 每个加油站距离起点距离
    public static int[] B; // 每个加油站可以加的油量

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        P = scanner.nextInt();
        A = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        System.out.println(new Expedition().solve());
    }

    public int solve() {
        int dis = P, res = 0;
        // 默认实现小顶堆，需要重新定义comparator实现大顶堆
        Queue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < N; i++) {
            if (A[i] <= dis) {
                pQueue.offer(B[i]);
            } else {
                if (pQueue.isEmpty()) return -1;
//                System.out.println(pQueue.peek());
                dis += pQueue.poll();
                res++;
                i--;
            }
        }
        return res;
    }
}
