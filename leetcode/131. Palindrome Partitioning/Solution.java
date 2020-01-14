import java.util.*;

public class Solution {
    /**
     * Partition list.
     * 使用经典回溯法的结构解，加上字串的回文子判断。
     *
     * @param s the s
     * @return the list
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        List<String> cur = new ArrayList<>();
        backtrack(s, 0, ans, cur);
        return ans;
    }
    public void backtrack(String s, int start, List<List<String>> ans, List<String> cur) {
        if (cur.size() > 0 && start >= s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                if (start == i) cur.add(Character.toString(s.charAt(start)));
                else cur.add(s.substring(start, i+1));
                backtrack(s, i+1, ans, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}