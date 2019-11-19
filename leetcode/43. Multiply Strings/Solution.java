public class Solution {
    /**
     * 两个字符串代表的数字相乘。
     * 解决大数问题的典型程序。
     * Time complexity: O(l1*l2)
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @return the string
     */
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] ans = new int[l1 + l2];
        for (int i = l1 -1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) -'0');
                int hi = i + j, lo = i + j + 1;
                int sum = ans[lo] + mul;
                ans[lo] = sum % 10;
                ans[hi] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            if(!(i == 0 && sb.length() == 0)) sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
