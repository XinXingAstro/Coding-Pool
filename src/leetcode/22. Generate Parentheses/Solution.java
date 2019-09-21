class Solution {
	//Brute Force
	//Time complexity: O(2^2n * n)
	//Space compleixty: O(2^2n * n)
    public List<String> generateParenthesis_BF(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }
    //深度优先遍历
    public void generateAll(char[] current, int pos, List<String> result) {
    	if (pos == current.length) {
    		if (valid(current))
    			result.add(new String(current));
    	} else {
    		current[pos] = '(';
    		generateAll(current, pos + 1, result);
    		current[pos] = ')';
    		generateAll(current, pos + 1, result);
    	}

    }
    public boolean valid(char[] current) {
    	int balance = 0;
    	for (char c : current) {
    		if (c == '(') balance++;
    		else balance--;
    		if (balance < 0) return false;
    	}
    	return (balance == 0);
    }

    //Backtracking
    //原理和深度优先遍历一样，实时记录左右括号数量
    //Time complexity: O(4^n/nsqrt(n))
    //Space complexity: O(4^n/nsqrt(n))
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<>();
    	backtrack(ans, "", 0, 0, n);
    	return ans;
    }
    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
    	if (cur.length() == max * 2) {
    		ans.add(cur);
    		return;
    	}
    	if (open < max)
    		backtrack(ans, cur + "(", open + 1, close, max);
    	if (close < open)
    		backtrack(ans, cur + ")", open, close + 1, max);
    }

    //Closure Number
    //Time complexity: O(4^n/sqrt(n))
    //Space complexity: O(4^n/sqrt(n))
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<>();
    	if (n == 0) {
    		ans.add("");
    	} else {
    		for (int c = 0; c < n; ++c)
    			for (String left : generateParenthesis(c))
    				for (String right : generateParenthesis(n - 1 - c))
    					ans.add("(" + left + ")" + right);
    	}
    	return ans;
    }
}