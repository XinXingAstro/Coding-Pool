public class MaxCommonDivisor {
    /**
     * 求 p 和 q 的最大公约数
     * 欧几里得算法：
     * 若 q 是 0 ，则最大公约数为 p 。否则，将 p 除以 q 得到余数 r ，
     * p 和 q 的最大公约数即为 q 和 r 的最大公约数。
     *
     *
     * @param p the p
     * @param q the q
     * @return the int
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}