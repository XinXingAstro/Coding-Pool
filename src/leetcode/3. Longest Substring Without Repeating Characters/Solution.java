class Solution {
	//Brute Force Search
	//注意字符串可能为null
	//注意字符串长度可能为1
	//Time complexity: O(n^2)
	//Space complexity: O(n)
    public int lengthOfLongestSubstring_bf(String s) {
        char str[] = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int len = 0, ans = 0;
        for (int i = 0; i < str.length; i++) {
        	if (!map.containsKey(str[i])) {
        		len++;
        		ans = Math.max(len, ans);
                map.put(str[i], i);
        	} else {
        		int first = map.get(str[i]);
        		map.put(str[i], i);
        		i = first;
                len = 0;
                map = new HashMap<>();
        	}
        }
        return ans;
    }

    //Brute Force Search
    //
}