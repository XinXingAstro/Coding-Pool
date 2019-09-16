class Solution {
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
}