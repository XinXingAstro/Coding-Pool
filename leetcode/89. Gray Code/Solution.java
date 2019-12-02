import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Gray code list.
     * 生成gray code模板代码。
     * My idea is to generate the sequence iteratively.
     * For example, when n=3, we can get the result based on n=2.
     * 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
     * The middle two numbers only differ at their highest bit,
     * while the rest numbers of part two are exactly symmetric of part one.
     * It is easy to see its correctness.
     *
     * @param n the n
     * @return the list
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int size = ans.size();
            for (int k = size-1; k >= 0; k--)
                ans.add(ans.get(k) | 1 << i);
        }
        return ans;
    }
}
