class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int ans = 0, bit = 1;
        while (bit <= m) bit <<= 1;
        while (m != 0 && n != 0) {
            if (m >= (bit / 2) && n < bit) {
                bit >>= 1;
                ans |= bit;
                m ^= bit;
                n ^= bit;
            } else {
                bit >>= 1;
                if (n >= bit) break;
            }
        }
        return ans;
    }
}