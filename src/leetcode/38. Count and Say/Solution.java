public class Solution {
    /**
     * 生成第n个报数序列（几个几几个几。。。）
     * 依次扫描上一报数序列，使用hash数组记录数字出现个数，
     * 遇到和前一数字不同的数时，就几个几添加到新序列中，
     * 然后清空该数出现的次数。
     * Time complexity: O(N)
     *
     * @param n the n
     * @return the string
     */
    public String countAndSay(int n) {
        String s = "1", cas = "";
        int[] t = new int[100];
        for (int i = 0; i < (n - 1); i++) {
            int cur = s.charAt(0) - '0';
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) - '0') != cur) {
                    cas += t[cur] + "" + cur;
                    t[cur] = 0;
                    cur = s.charAt(j) - '0';
                    t[cur]++;
                } else t[cur]++;
            }
            s = cas + t[cur] + s.charAt(s.length() - 1);
            t[cur] = 0;
            cas = "";
        }
        return s;
    }
}
