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
}
