
https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
According to the Wiki about what Topological sorting is (https://en.wikipedia.org/wiki/Topological_sorting)
and the Kahn's algorithm as shown below:
alt text
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edges
while S is non-empty do

remove a node n from S
add n to tail of L
for each node m with an edge e from n to m do
remove edge e from the graph
if m has no other incoming edges then
insert m into S
if graph has edges then
return error (graph has at least one cycle)
else
return L (a topologically sorted order)
```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int[] pre: prerequisites) {
            if (adjList[pre[1]] == null)
                adjList[pre[1]] = new ArrayList<>();
            adjList[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int el = queue.poll();
            if (adjList[el] != null) {
                for (int pre: adjList[el]) {
                    inDegree[pre]--;
                    if (inDegree[pre] == 0) queue.offer(pre);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) return false;
        }
        return true;
    }
}
```