class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '#' && sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            else if (cs[i] != '#') sb.append(cs[i]);
        }
        String a = sb.toString();
        sb.delete(0, sb.length());
        for (int i = 0; i < ct.length; i++) {
            if (ct[i] == '#' && sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            else if (ct[i] != '#') sb.append(ct[i]);
        }
        String b = sb.toString();
        return a.equals(b);
    }
}