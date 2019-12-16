import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            char key = s.charAt(j);
            if (map.containsKey(key))
                i = Math.max(i, map.get(key) + 1);
            ans = Math.max(ans, j-i+1);
            map.put(key, j);
        }
        return ans;
    }
}