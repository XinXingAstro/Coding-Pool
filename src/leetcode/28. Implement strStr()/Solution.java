class Solution {
	//双指针法
	//注意两种异常情况：
	//1）needle长度为0，应返回0
	//2）needle长度大于haystack长度，应返回-1
	//Time complexity: O(n^2)
	//Space complexity: O(1)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
    	int i = 0, hl = haystack.length(), nl = needle.length();
        for (; i < hl; i++) {
        	if (haystack.charAt(i) == needle.charAt(0)) {
        		int j = 0, k = i;
        		for (; j < nl && k < hl; j++, k++) {
        			if (haystack.charAt(k) != needle.charAt(j))	break;
        		}
        		if (j == nl) return i; 
        	}
        }
        return -1;
    }

    //Discuss most votes
    public int strStr(String  haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}