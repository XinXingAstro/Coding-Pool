import java.util.*;

public class Solution {
    /**
     * Group anagrams list.
     * 从字符串列表中找出具有相同字母得字符串放到一组。
     * 主要是容器之间类型转换方法的应用：
     * String.valueOf(): 将非String类型数据转换为String
     * map.values(): 将HashMap中的value值作为一个容器类型返回
     *
     * @param strs the strs
     * @return the list
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
