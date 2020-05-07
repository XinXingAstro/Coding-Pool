class Solution {
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            s = s.replace(s.charAt(i), t.charAt(i));
        }
        return s.equals(t);
    }
}