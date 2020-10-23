package _2018RoundA.A;

import java.util.*;
import java.io.*;
public class Solution {
    public long getBig(long N) {
       int[] nums = new int[20];
       int len = 0;
       for (; N > 0; len++) {
           nums[len] = (int)(N % 10);
           N /= 10;
       }
       // find first even
       int i = len-1;
       for (; i >= 0; i--) {
           if ((nums[i] & 1) == 1) {
               if (nums[i] < 9) {
                   // if first even smaller than 9
                   nums[i]++;
                   for (int j = i-1; j >= 0; j--) nums[j] = 0;
                   break;
               } else {
                   // if first even == 9
                   int j = i;
                   nums[j] = 0;
                   int carry = 2;
                   for (int k = j-1; k >= 0; k--) nums[k] = 0;
                   while (carry != 0) {
                       nums[++j] += carry;
                       carry = nums[j] / 10;
                   }
                   len = j + 1; // update array nums len
                   //i = len; // set i rescan
               }
           }
       }
       long ans = 0;
       for (int j = len-1; j >= 0; j--) {
           ans = ans * 10 + nums[j];
       }
       return ans;
    }

    public long getSmall(long N) {
        int[] nums = new int[20];
        int len = 0;
        for (; N > 0; len++) {
            nums[len] = (int)(N % 10);
            N /= 10;
        }
        // find first even
        int i = len-1;
        for (; i >= 0; i--) {
            if ((nums[i] & 1) == 1) {
                nums[i]--;
                for (int j = i-1; j >= 0; j--) nums[j] = 8;
                break;
            }
        }
        long ans = 0;
        for (int j = len-1; j >= 0; j--) {
            ans = ans * 10 + nums[j];
        }
        return ans;
    }

    public long minDis(long N) {
        long big = getBig(N);
        long small = getSmall(N);
        return Math.min(Math.abs(N-big), Math.abs(N-small));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        Solution s = new Solution();
        for (int i = 1; i <= T; i++) {
            long N = in.nextLong();
            System.out.println("Case #" + i + ": " + s.minDis(N));
        }
    }
}