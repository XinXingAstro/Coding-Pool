class Solution {
    //test case: [0, 1],[1, 1],[-1, 1],[1, -1],[-1, -1]
    //[-2147483648, -1], [-1, -2147483648], [-2147483648, 1], [1, -2147483648]
    public int divide(int dividend, int divisor) {
        boolean sign = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = true;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        long ans = ldivide1(ldividend, ldivisor);
        if (ans > Integer.MAX_VALUE) {
            return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            return sign ? (int)-ans : (int)ans;
        }
    }
    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        //找到最大的乘数，使得 divisor * multiple <= dividend
        long sum = ldivisor;
        long multiple = 1;
        //这里使用1，2，4，8...是考虑到性能问题，所以后面还要递归查找剩下的
        //可以想象为二分查找
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    //下面这种方法是超时的
    private long ldivide1(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor, multiple = 1;
        while ((sum * multiple) <= ldividend) {
            ++multiple;
        }
        return --multiple;
    }
}