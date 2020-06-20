class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int lo = 0, hi = num/2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            double sqr = (double)mid * (double)mid;
            if (sqr == (double)num) return true;
            else if (sqr < (double)num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}