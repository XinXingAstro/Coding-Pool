public class Solution {
    /**
     * Find median sorted arrays double.
     * Test case: [], [1] = 1.0; [3], [-2,-1] = -1.0;
     * 在统计学中，中位数是用来将集合划分为两个长度相等的子集，
     * 其中一个子集中的所有元素全都大于另一个子集中的所有元素。
     * 题解：
     * https://www.cnblogs.com/grandyang/p/4465932.html
     * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
     * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
     * Time complexity: O(log(2*min(N1,N2)))1
     * Space complexity: O(1)
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1); //确保第二个数组是短的那个
        int lo = 0, hi = N2 * 2; //在0~2N2范围内搜索，确保算法复杂度是O(log(2*min(N1, N2)))
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2; //尝试拆分nums2(较短数组)
            int mid1 = N1 + N2 - mid2; //计算出nums1的切分点
            //mid是扩充数组(加#)中切割位置的坐标，L，R是对应的原数组中切割位置两边数的坐标
            //下面是由切割位置计算出原数组中切割位置两边的数
            double L1 = (mid1 == 0) ? Double.MIN_VALUE : nums1[(mid1-1)/2];
            double L2 = (mid2 == 0) ? Double.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1*2) ? Double.MAX_VALUE : nums1[mid1/2];
            double R2 = (mid2 == N2*2) ? Double.MAX_VALUE : nums2[mid2/2];
            //切割是在较短数组中进行，所以lo, hi指针的调整也是在较短数组中进行
            if (L1 > R2) lo = mid2 + 1; //L2需向后移动
            else if (L2 > R1) hi = mid2 - 1; //L2需向前移动
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
        }
        return -1;
    }

    /**
     * Find median sorted arrays double.
     * 先将两数组合并，然后直接返回中位数。
     * Time complexity: O(N1+N2)
     * Space complexity: O(N1+N2)
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length, n1 = 0, n2 = 0, n3 = 0;
        int[] temp = new int[N1 + N2];
        while (n1 < N1 || n2 < N2) {
            if (n1 >= N1) {
                while (n2 < N2) temp[n3++] = nums2[n2++];
                break;
            }
            if (n2 >= N2) {
                while (n1 < N1) temp[n3++] = nums1[n1++];
                break;
            }
            if (nums1[n1] < nums2[n2]) temp[n3++] = nums1[n1++];
            else temp[n3++] = nums2[n2++];
        }
        return (temp[(N1+N2-1)/2] + temp[(N1+N2)/2]) / 2.0;
    }
}