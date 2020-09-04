// DAG Topological Sort
public class DAG_Topological_Sort {
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
