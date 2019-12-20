class Solution {
    /**
     * Longest palindrome string.
     * 中心扩散法
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length(), start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start + 1)) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
            
        }
        return s.substring(start, end + 1);
    }
    public int expand(String s, int left, int right) {
        int l = left, r = right, n = s.length();
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * Longest palindrome string.
     * 受到第4题的启发，基于Manacher's Alogrithm的中心扩散法
     * 将原字符串的所有切割位置用‘#’填充，
     * 如“abc”填充为"a#b#c",字符串长度变为2N-1，
     * 之后再基于每个切割位置进行中心扩散判断是否是palindrome串，在此过程中找到最长Palindrome串
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     *
     * @param s the s
     * @return the string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] c = s.toCharArray();
        int n = c.length, max = 0, start = 0, end = 0;
        for (int i = 0; i < (2*n-1); ++i) {
            int L = i / 2;
            int R = (i + 1) / 2;
            while (L >= 0 && R < n && c[L--] == c[R++]) {
                if ((R > L) && ((R-L-2) > max)) {
                    max = R - L - 2;
                    start = L + 1;
                    end = R - 1;
                }
            }
        }
        return s.substring(start, end+1);
    }

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