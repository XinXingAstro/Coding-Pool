import java.util.*;
import javafx.util.Pair;

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
}