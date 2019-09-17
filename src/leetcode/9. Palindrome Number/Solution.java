class Solution {
    //Expand from Center
    //Time complexity: O(log10n)
    //Space complexity: O(log10n)
    public boolean isPalindrome(int x) {
        char[] chr = Integer.toString(x).toCharArray();
        int left = 0, right = 0, n = chr.length;
        left = n / 2 - 1;
        if (n & 1 == 1) right = n / 2 + 1;
        else right = n / 2;
        while (left >= 0 && right < n) {
            if (chr[left] != chr[right]) return false;
        }
        return true;
    }

    //Revert half of the number
    //Time complexity: O(log10n)
    //Space complexity: O(log10n)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == (revertNum/10);
    }
}