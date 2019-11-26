public class Solution {
    /**
     * 图的深度优先遍历，很经典的题
     *
     *
     * @param board the board
     * @param word  the word
     * @return the boolean
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word.toCharArray(), 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j, char[] word, int k) {
        if (k == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[k] != board[i][j])
            return false;
        board[i][j] ^= 256; //(java中char类型有16位)标记board[i][j]已访问
        boolean ans = dfs(board, i+1, j, word, k+1)
                || dfs(board, i, j+1, word, k+1)
                || dfs(board, i-1, j, word, k+1)
                || dfs(board, i, j-1, word, k+1);
        board[i][j] ^= 256;
        return ans;
    }
}
