class Solution {
    //Time complexity: O(log(x))
    //Space complexity: O(log(x))
    public int reverse(int x) {
        if (x == 0) return 0;
        List<Integer> nums = new ArrayList<>();
        int i = 0;
        double ans = 0;
        boolean flag = x > 0 ? false : true;
        if (flag) x = -x;
        while (x % 10 == 0) x /= 10;
        while (x > 0) {
            nums.add(x % 10);
            x /= 10;
        }
        while (i < nums.size()) {
            ans *= 10;
            ans += nums.get(i++);
            if (ans > Integer.MAX_VALUE) return 0;
        }
        return flag ? (int)-ans : (int)ans;
    }

    //Pop and Push Digits & Check before Overflow
    //Time complexity: O(log(x))
    //Space complexity: O(log(x))
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}