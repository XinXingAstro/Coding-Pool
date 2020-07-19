import java.util.*;
public class RabinKarp {
    // Rabin-Karp字符串编码算法的本质是对自负串进行哈希。
    // 为了能够快速计算出字符串编码，可以将字符串看成一个26进制数（这个进制由可能出现的字符决定）
    // 它对应的10进制的值就是字符串的编码值
    private int a; // 字符串中可能出现字母的个数，进制数
    private int L; // 子字符串的长度
    private int n; // 原字符串长度
    private long modulus; // 为了避免溢出对结果进行求模

    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; i++) {
            h = (h * a + nums[i]) % modulus;
        }
        
        // already seen hashes of strings of length L
        Set<Long> seen = new HashSet<>();
        seen.add(h);

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i<= L; i++) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - L + 1; start++) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    // 找到S中最长重复子串
    public String longestDupSubstring(String S) {
        n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        // base value for the rolling hash function
        a = 26;
        // modulus value for the rolling hash function to avoid overflow
        modulus = (long)Integer.MAX_VALUE;

        // binary search, L = repeating string length
        int left = 1, right = n;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) {
                left = L + 1;
            } else {
                right = L;
            }
        }
        
        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }
}