public class Solution {
    /**
     * Longest palindrome string.
     * Manacher's Alogrithm
     * Test case: "babad", "cbbd", "ccc"
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        char[] c = s.toCharArray();
        char[] t = new char[2 * c.length + 3]; //t用来存储存储后的字符串
        int[] p = new int[t.length]; //p矩阵表示以i为中心的回文字的半径, 如果两面字符不同则为0
        int C = 0, R = 0, maxC = 0, maxR = 0; //C表示目前最长回文子的中心，R表示以C为中心的回文子半径，maxC，maxR则记录整个字符串中的最值
        //对字符串进行预处理，将开头加上”@#“，每个字母之间插入”#“，之后加上”#$"
        t[0] = '@'; t[1] = '#'; t[t.length-1] = '$';
        for (int i = 0; i < c.length; i++) {
            t[2*i+2] = c[i];
            t[2*i+3] = '#';
        }
        //处理完后进入处理流程
        for (int i = 1; i < t.length-1; i++) {
            //i从C位置出来以后，如果落在上个回文子的半径内，则p[i]应当是下面两个值中较小的那个
            //值1：以i为中心的回文字的半径有可能比之前回文字的半径大，所以先赋值为C+R-i，外面的是否符合回文子等待while中检查
            //值2：回文子是对称的，C-（i-C）是i以C为中心的对称点，该点的p[j]值（半径）如果比R小的化，则定有p[i] = p[j], 如果p[j]比R大的化，则得赋值为值1，后续等待验证
            if (C+R > i) p[i] = Math.min(C+R-i, p[C-(i-C)]);
            //不管上面p[i]是什么值，都需要验证p[i]还能否继续扩展
            while (t[i+(p[i]+1)] == t[i-(p[i]+1)]) p[i]++;
            //如果以i为中心回文子得右边界大于上一个回文子得右边界，则C，R要向右移动
            if ((i+p[i]) > (C+R)) {
                C = i;
                R = p[i];
            }
            //如果当前回文子的半径大于最大半径，则更新整个字符串的最值
            if (p[i] > maxR) {
                maxR = p[i];
                maxC = i;
            }
        }
        //将处理后的字符串中最大回文子的边界转换为原字符串的边界也很方便，除2既可
        return s.substring((maxC-maxR)/2, (maxC+maxR)/2);
    }
}