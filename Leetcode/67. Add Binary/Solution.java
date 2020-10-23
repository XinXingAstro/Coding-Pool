import java.util.*;

public class Solution {
    /**
     * 两个String类型的二进制数相加.
     * 这是第一版代码比较笨
     *
     * @param a the a
     * @param b the b
     * @return the string
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length(), lb = b.length(), i, j;
        int carry = 0;
        for (i = la-1, j = lb-1; i >= 0 && j >= 0; i--, j--) {
            int sum = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        String s = i >= 0 ? a : b;
        int k = i >= 0 ? i : j;
        while (carry > 0 && k >= 0) {
            int sum = (s.charAt(k)-'0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            k--;
        }
        if (carry > 0) sb.insert(0, carry);
        else if (k >= 0) sb.insert(0, s.substring(0, k+1));
        return sb.toString();
    }

    /**
     * Add binary string.
     * !!! StringBuilder 的append()方法的效率要远高于inser()方法 !!!
     * 所以这道题更高效的做法是，先用append()方法构建二进制数结果，然后
     * 用reverse()方法将原字符串翻转后返回。
     *
     * @param a the a
     * @param b the b
     * @return the string
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry = 0, sum = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) sum += (a.charAt(i--) - '0');
            if (j >= 0) sum += (b.charAt(j--) - '0');
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
