import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Plus one int [ ].
     *
     * Time compelexity: O(n)
     * Space complexity: O(n)
     *
     * @param digits the digits
     * @return the int [ ]
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length, carry = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            int num = digits[i] + carry;
            list.add((num % 10));
            carry = num / 10;
        }
        if (carry != 0) list.add(carry);
        int[] ans = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--)
            ans[list.size()-1-i] = list.get(i);
        return ans;
    }

    /**
     * Plus one int [ ].
     * 看别人的代码多简洁
     *
     * @param digits the digits
     * @return the int [ ]
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
