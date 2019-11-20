import java.util.*;

public class Solution {
    /**
     * Simplify path string.
     * 使用“/”对path进行分割，然后使用栈进行处理的方法，
     * 优点是代码比较短，缺点是速度较慢。
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param path the path
     * @return the string
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String ans = "";
        for (String dir : stack) ans = "/" + dir + ans;
        return ans.isEmpty() ? "/" : ans;
    }

    /**
     * Simplify path string.
     * 使用ArrayList代替stack重新写了一遍，速度有所提高。
     *
     * @param path the path
     * @return the string
     */
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].equals("..")) {
                if (list.size() > 0) list.remove(list.size()-1);
                else continue;
            } else if (!dir[i].equals("") && !dir[i].equals(".")) list.add("/" + dir[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
