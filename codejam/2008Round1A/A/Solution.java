import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = in.nextInt();
            int[] v1 = new int[n];
            int[] v2 = new int[n];
            for (int j = 0; j < n; j++) {
                v1[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                v2[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + new Solution().solve(v1, v2));
        }
    }
    public long solve(int[] v1, int[] v2) {
        Arrays.sort(v1);
        Arrays.sort(v2);
        long ans = 0;
        for (int i = 0; i < v1.length; i++) {
            ans += ((long)v1[i] * (long)v2[v2.length - 1 - i]);
        }
        return ans;
    }
}