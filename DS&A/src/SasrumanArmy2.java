import java.util.*;
public class SasrumanArmy2 {
    public int solve(int N, int R, int[] X) {
        int i = 0, ans = 0;
        while (i < N){
            int s = X[i++];
            while (i < N && X[i] <= s+R) i++;
            int c = X[i-1];
            ans++;
            while (i < N && X[i] <= c+R) i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        /*int N, R;
        int[] X;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        R = s.nextInt();
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = s.nextInt();
        }*/
        int N = 6, R = 10;
        int[] X = {1, 7, 15, 20, 30, 50};
        System.out.println(new SasrumanArmy2().solve(N, R, X));
    }
}
