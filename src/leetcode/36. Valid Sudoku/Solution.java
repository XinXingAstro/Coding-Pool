public class Solution {
    /**
     * 判断数独数组是否合规
     * 分别扫描每个3x3小方格，判断小方格中数字是否重复，判断行列是否有重复。
     * Time complexity: O(N)
     *
     * @param board the board
     * @return the boolean
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List> map = new HashMap<>();
        for (int i = 0; i < 7; i+=3) {
            for (int j = 0; j < 7; j+=3) {
                boolean[] flag = new boolean[10];
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] != '.') {
                            //3x3 sub-boxes without repetition
                            int num = board[row][col] - '0';
                            if (flag[num] == true) return false;
                            else flag[num] = true;
                            //row col without repetition
                            if (map.containsKey(num)) {
                                List<Integer> list = map.get(num);
                                for (int p = 0; p < list.size(); p+=2) {
                                    if (list.get(p) == row) return false;
                                    if (list.get(p + 1) == col) return false;
                                }
                                list.add(row);
                                list.add(col);
                            } else {
                                ArrayList<Integer> list = new ArrayList<>();
                                list.add(row);
                                list.add(col);
                                map.put(num, list);
                            }

                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 判断数独数组是否有效
     * 使用HashSet+字符串编码简化代码，字符串编码规则："row(num)col"
     * '4'在第7行编码为"(4)7"
     * '4'在第7列编码为"7(4)"
     * '4'在右上角3x3方格中编码为"0(4)2"
     * 对于每一个数字都尝试将这三个字符串加入HashSet中,
     * 如果set返回false说明出现重复,则返回false.
     *
     * @param board the board
     * @return the boolean
     */
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
