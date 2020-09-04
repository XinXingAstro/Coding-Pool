// Manacher's Algorithm - Linear Time Longest Palindromic Substring
public class Manacher {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        char[] c = s.toCharArray();
        char[] t = new char[2 * c.length + 3]; 
        t[0] = '@'; t[1] = '#'; t[t.length-1] = '$';
        int[] p = new int[t.length];                         // 存储以i为中心的回文长度
        int C = 0, R = 0, maxC = 0, maxR = 0;                // C:center, R:radio
        for (int i = 0; i < c.length; i++) {
            t[2*i+2] = c[i];
            t[2*i+3] = '#';
        }
        for (int i = 1; i < t.length-1; i++) {s
            if (C+R > i) p[i] = Math.min(C+R-i, p[C-(i-C)]); // 如果i在有边界以内
            while (t[i+(p[i]+1)] == t[i-(p[i]+1)]) p[i]++;   // 向外扩展
            if ((i+p[i]) > (C+R)) {                          // 如果以i为中心的右边界更右则更新
                C = i;
                R = p[i];
            }
            if (p[i] > maxR) {                               // 同时更新最值 
                maxR = p[i];
                maxC = i;
            }
        }
        return s.substring((maxC-maxR)/2, (maxC+maxR)/2);    // t数组和原字符串左右边界映射直接/2
    }
}
