class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chr = s.toCharArray();
        int i = 0, n = chr.length;
        Deque<Character> stack = new LinkedList<>();
        if (chr[0] == ')' || chr[0] == ']' || chr[0] == '}' || n % 2 != 0)
        	return false;
        while (i < n) {
        	if (chr[i] == '(' || chr[i] == '[' || chr[i] =='{') {
        		stack.push(chr[i++]);
        	} else if (chr[i] == ')') {
        		if (stack.peek() == '(') {
        			stack.pop();
        			i++;
        		} else {
        			return false;
        		}
        	} else if (chr[i] == ']') {
        		if (stack.peek() == '[') {
        			stack.pop();
        			i++;
        		} else {
        			return false;
        		}
        	} else if (chr[i] == '}') {
        		if (stack.peek() == '{') {
        			stack.pop();
        			i++;
        		} else {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }

    //使用HashMap减少if-else
    public boolean isValid(String s) {
    	if (s == null || s.length() == 0) return true;
    	Map<Character, Character> map = new HashMap<>();
    	map.put(')', '(');
    	map.put(']', '[');
    	map.put('}', '{');
    	char[] chr = s.toCharArray();
    	Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < chr.length; i++) {
    		if (map.containsKey(chr[i])) {
    			if (stack.isEmpty() || stack.pop() != map.get(chr[i]))
    				return false;
    		} else {
    			stack.push(chr[i]);
    		}
    	}
    	return stack.isEmpty();
    }
}