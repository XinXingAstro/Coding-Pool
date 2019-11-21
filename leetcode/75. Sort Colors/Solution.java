public class Solution {
    /**
     * Sort colors.
     * 遍历两遍，第一遍统计0 1 2出现的次数，第二遍设置对应的值。
     *
     * @param nums the nums
     */
    public void sortColors(int[] nums) {
        int[] map = new int[3];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        int index = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < map[i]; j++) {
                nums[++index] = i;
            }
        }
    }
}
