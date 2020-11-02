package _8_String_to_Integer_atoi;

class Solution {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chr = str.toCharArray();
        int i = 0, ans = 0, pop = 0;
        boolean minu = false, start = false;
        while (i < chr.length){
            if ((chr[i] >= '0' && chr[i] <= '9')) {
                start = true;
                pop = minu ? '0' - chr[i] : chr[i] - '0';
                if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && chr[i] > '7')) return Integer.MAX_VALUE;
                if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && chr[i] > '8')) return Integer.MIN_VALUE;
                ans = ans * 10 + pop;
                i++;
            } else if(!start && chr[i] == '-') {
                start = true;
                minu = true;
                i++;
            } else if (!start && chr[i] == '+') {
                start = true;
                i++;
            } else if (!start && chr[i] == ' ') {
                i++;
            } else break;
        }
        return ans; 
    }
}