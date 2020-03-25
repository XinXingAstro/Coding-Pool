// 字典序最小问题：每次从一个字符串开头或结尾取一个字符，生成一个字典序最小的字符串
public class BestCowLine {
    // 输入
    public int MAX_N = 1000000;
    public int N; // 字符串长度
    char[] S = new char[MAX_N + 1];

    public String solve() {
        // 剩余的而字符串为S[a], S[a+1], ... ,S[b]
        int a = 0, b = N-1; // a指向字符串开头，b指向字符串结尾
        StringBuilder ans = new StringBuilder();

        while (a <= b) {
            // 比较开头和结尾的字符
            boolean left = false;
            for (int i = 0; a + i <= b; i++) {
                if (S[a+i] < S[b-i]) {
                    left = true;
                    break;
                } else if (S[a+i] > S[b-i]) {
                    left = false;
                    break;
                }
            }
            if (left) ans.append(S[a++]);
            else ans.append(S[b--]);
        }
        return ans.toString();
    }
}
