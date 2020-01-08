import javafx.util.Pair;
import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length
        int l = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from ans given word. By changing one letter at a time.
        Map<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < l; i++) {
                        // Key is the generic word
                        // Value is a list of word which have the same intermediate generic word
                        String newWord = word.substring(0, i) + '*' + word.substring(i+1, l);
                        ArrayList trans = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        trans.add(word);
                        allComboDict.put(newWord, trans);
                    }
                });
        // Oueue for BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        //Visited to make sure we don't repeat processing same word
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node .getKey();
            int level = node.getValue();
            for (int i = 0; i < l; i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, l);

                // Next states are all the words which share the same intermediate state
                for (String adWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at ans point if we find what we are looking for
                    // i.e. the end word - we can return with the answer
                    if (adWord.equals(endWord)) return level+1;
                    // Orherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adWord)) {
                        visited.put(adWord, true);
                        q.add(new Pair<>(adWord, level+1));
                    }
                }
            }
        }
        return 0;
    }




    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        begin.add(beginWord);
        end.add(endWord);
        return helper(begin, end, dict, 1);
    }
    private int helper(Set<String> begin, Set<String> end, Set<String> dict, int level) {
        if (begin.isEmpty() || end.isEmpty()) return 0;
        dict.removeAll(begin);
        Set<String> next = new HashSet<>();
        for (String s : begin) {
            char[] word = s.toCharArray();
            for (int i = 0; i < word.length; i++) {
                char old = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c;
                    String newWord = new String(word);
                    if (!dict.contains(newWord))
                        continue;
                    if (end.contains(newWord))
                        return level + 1;
                    next.add(newWord);
                }
                word[i] = old;
            }
        }
        if (next.size() < end.size())
            return helper(next, end, dict, level + 1);
        else
            return helper(end, next, dict, level + 1);
    }
}