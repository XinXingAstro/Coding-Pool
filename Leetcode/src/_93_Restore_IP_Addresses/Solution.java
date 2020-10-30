import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Restore ip addresses list.
     * 用回溯算法也可以做，但是下面这种方法更简单而且高效。
     * 以不同方式对字符串进行分割，一共只有81(3^4)种分割方式,
     * 如果这种分割方式产生字串的长度相加等于字符串的长度，则进行进一步判断
     * 如果各字串代表的数字都小于等于255，则对字符串进行拼接，
     * 如果字串种没有0开始的字符串，则最后字符串的长度应该比原字符串的长度长3，
     * 如果上述条件全部符合，则在答案列表中加入。
     *
     * @param s the s
     * @return the list
     */
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if (a+b+c+d == n) {
                            int A = Integer.valueOf(s.substring(0, a));
                            int B = Integer.valueOf(s.substring(a, a+b));
                            int C = Integer.valueOf(s.substring(a+b, a+b+c));
                            int D = Integer.valueOf(s.substring(a+b+c, a+b+c+d));
                            if (A <= 255 && B <= 255 & C <= 255 && D <= 255) {
                                String ip = A + "." + B + "." + C + "." + D;
                                //由于有很多0开头的子串，在Integer.valueOf时只剩有效位，所以这里必须要判断
                                if (ip.length() == (n+3))
                                    ans.add(ip);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
