import java.util.*;
class Solution {
    public boolean[][] used;
    public List<String> findWords(char[][] board, String[] words) {
        // if (board == null) return new ArrayList<>();
        used = new boolean[board.length][board[0].length];
        Map<Character, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i].charAt(0))) {
                map.put(words[i].charAt(0), new ArrayList<>());
            }
            map.get(words[i].charAt(0)).add(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (map.containsKey(board[i][j])) {
                    for (String w : map.get(board[i][j])) {
                        if (dfs(board, i, j, w, 0) && !list.contains(w))
                            list.add(w);
                    }
                }
            }
        }
        return list;
    }

    public boolean dfs(char[][] b, int i, int j, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || used[i][j] || b[i][j] != word.charAt(k)) return false;
        used[i][j] = true;
        boolean ans = dfs(b, i+1, j, word, k+1)
                || dfs(b, i-1, j, word, k+1)
                || dfs(b, i, j+1, word, k+1)
                || dfs(b, i, j-1, word, k+1);
        used[i][j] = false;
        return ans;
    }
}