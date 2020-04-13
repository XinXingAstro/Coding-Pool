```java
public class A.Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] a, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == a.length) ans.add(new ArrayList<>(path));
        else {
            for (int i = 0; i < a.length; i++) {
                path.add(a[i]);
                backtrack(a, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
```
当传入数组为[1,2,3]时其输出为：
```
[[1, 1, 1], [1, 1, 2], [1, 1, 3],
 [1, 2, 1], [1, 2, 2], [1, 2, 3],
 [1, 3, 1], [1, 3, 2], [1, 3, 3], 
 [2, 1, 1], [2, 1, 2], [2, 1, 3], 
 [2, 2, 1], [2, 2, 2], [2, 2, 3], 
 [2, 3, 1], [2, 3, 2], [2, 3, 3], 
 [3, 1, 1], [3, 1, 2], [3, 1, 3],
 [3, 2, 1], [3, 2, 2], [3, 2, 3], 
 [3, 3, 1], [3, 3, 2], [3, 3, 3]]
```
当传入数组为3位数时，排列个数为3^3=27个。<br>
当传入数组为4位数时，排列个数为4^4=256个。<br>
当传入数组为n为数时，排列个数为n^n个。<br>
可以将其想象为一个有n个数，每位数有n种可能的密码锁的所有组合数。<br>
在这个算法之上加入各种条件判断，就可以解决如Permutations, combinationSum等问题。
