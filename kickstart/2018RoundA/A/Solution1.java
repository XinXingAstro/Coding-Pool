// 只能解决Small Test case
import java.util.*;
import java.io.*;
public class Solution {
    public static int minDis(int N) {
        int dis = 0;
        for (int i = 0; i <= N; i++) {
            int plus = N + i;
            int minu = N - i;
            if (isAllEven(plus) || isAllEven(minu)) {
                dis = i;
                break;
            }
        }
        return dis;
    }

    public static boolean isAllEven(int n) {
        if (n < 0) n = -n;
        while (n > 0) {
            int digit = n % 10;
            if ((digit & 1) == 1) return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            System.out.println("Case #" + i + ": " + minDis(N));
        }
    }
}