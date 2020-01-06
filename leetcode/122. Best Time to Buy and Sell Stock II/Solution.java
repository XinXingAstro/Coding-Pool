import java.util.*;

public class Solution {
    /**
     * Max profit int.
     * 顺序遍历，将所有利润全都加起来
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param prices the prices
     * @return the int
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = prices.length-1; i > 0; i--) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}