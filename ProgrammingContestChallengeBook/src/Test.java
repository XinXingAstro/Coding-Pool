import java.util.*;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}
