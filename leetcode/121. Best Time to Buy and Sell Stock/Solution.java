import java.util.*;

public class Solution {
    /**
     * Max profit int.
     * 一遍遍历找到最大收益值。
     * 先找到目前的最小值，然后计算最大收益。
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param prices the prices
     * @return the int
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else if ((prices[i]-minPrice) > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}