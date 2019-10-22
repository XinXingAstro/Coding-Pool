import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
