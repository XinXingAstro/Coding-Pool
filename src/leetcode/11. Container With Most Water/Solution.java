class Solution {
    //Brute Force
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public int maxArea_bf(int[] height) {
        int n = height.length, ans = 0;
        for (int i = 0;  i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return ans;
    }

    //Two Pointer Approach
    //尽量让短板变长，整体的容积就会变大
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int maxArea(int[] height) {
        int n = height.length, i = 0, j = n - 1, ans = 0;
        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j])*(j - i));
            //指向较短板的指针往前走，整体容积才有可能更大
            if (height[i] < height[j]) i++;
            else j--;
        }
        return ans;
    }
}