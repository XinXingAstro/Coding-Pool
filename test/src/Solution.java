import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(Math.abs(a - b));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}