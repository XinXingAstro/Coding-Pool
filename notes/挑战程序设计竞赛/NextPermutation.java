
public class NextPermutation {
    boolean[] used = new boolean[MAX_N];
    int[] perm = new int[MAX_N];

    // 生成 {0，1，2，3，4，。。。，n-1} 的 n！种排列
    public void permutation1(int pos, int n) {
        if (pos == n) {
            /*
            * 这里编写需要对perm进行的操作
            * */
            return ;
        }

        // 针对perm的第pos个位置，究竟使用0 ~ n-1中的哪一个及逆行循环
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                perm[pos] = i;
                // i 已经被使用了，所以把标志位置为true
                used[i] = ture;
                permutation1(pos + 1, n);
                // 返回之后把标志复位
                used[i] = false;
            }
        }
        return ;
    }

    // 即使有重复的元素也会生成所有的排列
    // next_permutation是按照字典序来生成下一个排列的
    int perm2[MAX_N];

    public void permutation2(int n) {
        for (int i = 0; i < n; i++) {
            perm2[i] = i;
        }
        do {
            /*
            *  这里写需要对perm2及逆行的操作
            * */
        } while (next_permutation(perm2, perm2 + n));
        // 所有的排列都生成后，next_permutation会返回false
        return ;
    }
}