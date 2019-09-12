class Solution {
    //Brute-force search
    //Time complexity: O(n^2). n <= 1000
    //Space complexity: O(1).
    public int[] twoSum_bf(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < (nums.length - 1); i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //Two-pass Hash-map
    //Time complexity: O(n). n <= 10^6
    //Space complexity: O(n).
    public int[] twoSum_2phm(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two solution");
    }

    //One-pass Hash-map
    //Time complexity: O(n). n <= 10^6
    //Space complexity: O(n).
    public int[] twoSum_1phm(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two solution");
    }
}