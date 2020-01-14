import java.util.*;

public class Solution {
    int minCut = Integer.MAX_VALUE;
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        backtrack(s, 0, 0);
        return minCut;
    }
    public void backtrack(String s, int start, int cut) {
        if (start >= s.length()) {
            if (cut < minCut) minCut = cut;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                cut++;
                backtrack(s, i+1, cut);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}