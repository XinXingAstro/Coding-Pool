// Fence Repair 问题，让切板的开销最少
import java.util.*;
public class FenceRepair {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = s.nextInt();
        }
        System.out.println(new FenceRepair().minSpending(L));
    }

    public long minSpending(int[] L) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < L.length; i++) list.add(L[i]);
        long ans = 0;
        while (list.size() > 1) {
            // 找出最短的两块板的位置min1和min2
            int min1 = 0, min2 = 1;
            if (list.get(min1) > list.get(min2)) swap(min1, min2);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) < list.get(min1)) {
                    min1 = i;
                } else if (list.get(i) < list.get(min2)) {
                    min2 = i;
                }
            }
            int temp = list.get(min1) + list.get(min2);
            ans += temp;
            list.set(min1, temp);
            list.remove(min2);
        }
        return ans;
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
