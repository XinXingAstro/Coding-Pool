class Solution {
	//Brute Force Search
    //判断所有子串中是否存在重复字符
    //Time complexity：O(n^3)
    //Space complexity: O(min(n,m))
    public int lengthOfLongestSubstring_bf1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) ans = Math.max(ans, (j - i));
            }
        }
        return ans;
    }
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }

    //Brute Force Search
	//注意字符串可能为null
	//注意字符串长度可能为1
	//Time complexity: O(n^2)
	//Space complexity: O(n)
    public int lengthOfLongestSubstring_bf2(String s) {
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

    //Sliding Window
    //Time complexity: O(n).
    //Space complexity: O(min(m, n)).
    public int lengthOfLongestSubstring_sw(String s) {
        int start = 0, end = 0, ans = 0, n = s.length();
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                ans = Math.max(ans, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return ans;
    }

    //Slidng Window Optimized
    //use HashMap
    //Time complexity: O(n)
    //Space complexity: O(min(m, n))
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            //如果前面包含s.charAt(j)直接把i跳到该字符最后出现位置的后一个位置
            if (map.containsKey(s.charAt(j))) {
                //由于跟j位置字符重复的字符有可能出现在i的前面，为了防止重复判断，这里要用Math.max选择最新位置
                //如“abba”当检查到最后一个a的时候i应该为2，但如果不用Math.max，则i会变为1.
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
    //如果知道字符集就可以将HashMap换成数组
    //int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    //int[128] for ASCII
    //int[256] for Extended ASCII
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int ans = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1; //index[]中存的是i指向的位置
        }
        return ans;
    }
    
}