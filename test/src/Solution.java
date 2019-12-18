public class Solution {
    /**
     * Find median sorted arrays double.
     * 先将两数组合并，然后直接返回中位数。
     * Time complexity: O(N1+N2)
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