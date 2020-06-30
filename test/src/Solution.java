import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(final String s, final String[] words) {
        int wlen = words[0].length;
        List<String> list = new ArrayList<>();
        boolean[] used = new boolean[words.length];
        for (String w : words) {
            list.add(w);
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + wlen);
        }
    }
}
