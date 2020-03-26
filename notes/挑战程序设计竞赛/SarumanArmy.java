import java.util.Arrays;

/*
* Saruman's Army问题
* 直线上有N个点，从这些点中选若干个点加标记，对于每一个点，
* 其距离为R以内的区域里必须有标记点。在满足这个条件下尽可能
* 少的标记点。
* */
public class SarumanArmy {
    public int N, R;
    int X[MAX_N];

    public int solve() {
        Arrays.sort(X);

        int i = 0, ans = 0;
        while (i < N) {
            // s是没有被覆盖的最左的点的位置
            int s = X[i++];

            // 一直向右前进直到距S的距离大于R的点
            while (i < N && X[i] <= s + R) i++;

            // p是新加上标记的点的位置
            int p = X[i-1];
            // 一直向右前进知道距p的距离大于R的点
            while (i < N && X[i] <= p + R) i++;

            ans++;
        }

        return ans;
    }
}
