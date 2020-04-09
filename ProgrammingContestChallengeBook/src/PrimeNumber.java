/*
* 素性测试O(sqrt(n))
* 约数枚举O(sqrt(n))
* 证书分解O(sqrt(n))
* */
import java.util.*;
public class PrimeNumber {
    public static int N;
    public static int MAX_N = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        System.out.println(new PrimeNumber().sieve(N));
    }

    // 素性测试O(sqrt(n))
    public boolean is_prime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return n != 1; // 1是例外
    }

    // 约数枚举O(sqrt(n))
    public List<Integer> divisor(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != (n / i)) res.add(n / i);
            }
        }
        return res;
    }

    // 整数分解O(sqrt(n))
    public int[] prime_factor(int n) {
        int[] res = new int[(int)Math.sqrt(n)];
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ++res[i];
                n /= i;
            }
        }
        if (n != 1) res[n] = 1;
        return res;
    }

    /*
    * 求解区间内所有的素数
    * 埃式筛法:
    * 首先将2-n内所有的素数都写下来，然后把表中所有2的倍数都删去，
    * 表中剩余的最小的数字是3，是素数，然后把表中所有3的倍数都删掉，
    * 以此类推，如果表中剩余的最小的数是m，m就是素数，然后把表中所有m的倍数都删掉，
    * 反复操作就能枚举出n以内所有的素数。
    * 时间复杂度：O(nloglogn)
    * */
    // 返回n以内素数的个数
    public int sieve(int n) {
        int[] prime = new int[MAX_N]; // 第i个素数，用于存储找到的素数
        boolean[] is_prime = new boolean[MAX_N + 1]; // is_prime[i]为true表示i是素数
        int p = 0;
        for (int i = 0; i <= n; i++) is_prime[i] = true;
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (is_prime[i]) {
                prime[p++] = i;
                for (int j = 2 * i; j <= n; j += i) is_prime[j] = false;
            }
        }
        return p;
    }
}
