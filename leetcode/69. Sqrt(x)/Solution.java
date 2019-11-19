import java.util.*;

public class Solution {
    /**
     * 牛顿迭代法计算开平方
     *
     * @param x the x
     * @return the int
     */
    public int mySqrt(int x) {
        double err = 0.1;  //err表示误差
        double t = x;
        while (Math.abs(x - t*t) > err)
            t = (t + x/t) / 2.0;
        return (int)t;
    }

    /**
     * 二分查找法计算开平方
     *
     * @param x the x
     * @return the int
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            //这里的条件判断是非常严谨的一个符号都不能变
            if (mid <= (x/mid) && (mid+1) > x/(mid+1)) return mid;
            else if (mid < x/mid) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return right;
    }
}
