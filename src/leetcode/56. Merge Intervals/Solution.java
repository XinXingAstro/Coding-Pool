import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 合并间隙
     * 两个知识点：
     * 1）2D数组以某一列排序的写法。
     * 2）ArrayList转换为数组的写法。
     *
     * @param intervals the intervals
     * @return the int [ ] [ ]
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return new int[0][];
        //以第一列为键给intervals排序（升序）
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[0], b = o2[0];
                return a < b ? -1 : a == b ? 0 : 1;
            }
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果end>=后一个start说明有重叠
            if (end >= intervals[i][0]) end = Math.max(intervals[i][1], end);
            else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]); //这种写法应该记住
    }
}
