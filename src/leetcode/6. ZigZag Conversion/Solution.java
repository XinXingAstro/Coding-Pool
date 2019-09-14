class Solution {
    //Sort by Row
    /*SB1 -->P---->A---->H---->N
      SB2 -->A->P->L->S->I->I->G
      SB3 -->Y---->I---->R  

      ans = SB1->SB2->SB3        */
    //Time complexity: O(n) where n = len(s)
    //Space complexity: O(n)
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int curRow = 0;
        boolean goingDown = false;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == numRows - 1 || curRow == 0) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows)
            ans.append(row);
        return ans.toString();
        
    }

    //Visit by Row
}