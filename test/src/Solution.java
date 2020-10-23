import java.util.*;

class Solution {
    private class Edge {
        private String from;
        private String to;
        private double weight;
        public Edge(String f, String t, double w) {
            from = f;
            to = t;
            weight = w;
        }
    }
    private Map<String, List<Edge>> G;
    private double[] ans;
    private double res;
    private Set<String> marked;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        G = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String cur = eq.get(0);
            String next = eq.get(1);
            if (!G.containsKey(cur)) {
                G.put(cur, new ArrayList<>());
            }
            if (!G.containsKey(next)) {
                G.put(next, new ArrayList<>());
            }
            Edge e1 = new Edge(cur, next, values[i]);
            G.get(cur).add(e1);
            Edge e2 = new Edge(next, cur, 1/values[i]);
            G.get(next).add(e2);
        }
        ans = new double[queries.size()];
        marked = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String a = q.get(0), b = q.get(1);
            if (!G.containsKey(a) || !G.containsKey(b)) {
                ans[i] = -1.0;
            } else {
                marked.clear();
                dfs(a, b, 1.0);
                ans[i] = res;
            }
        }
        return ans;
    }

    private void dfs(String cur, String end, double div) {
        System.out.println(cur + " " + div);
        if (cur.equals(end)) {
            res = div;
            return;
        }
        marked.add(cur);
        for (Edge e : G.get(cur)) {
            if (!marked.contains(e.to)) {
                System.out.println(e.from + "->" + e.to);
                dfs(e.to, end, div * e.weight);
            }
        }
    }
}

