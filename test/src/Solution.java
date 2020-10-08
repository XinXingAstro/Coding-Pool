class Solution {
    private class UF {
        private int[] par;
        private int[] rank;
        public UF(int size) {
            par = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) par[i] = i;
        }
        public int find(int x) {
            if (par[x] != x) par[x] = find(par[x]);
            return par[x];
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        int[] ans1 = null;
        int[] ans2 = null;
        for (int[] e : edges) {
            if (uf.par[e[1]] != e[1]) {
                ans1 = new int[]{uf.par[e[1]], e[1]};
                ans2 = new int[]{e[0], e[1]};
                e[1] = -1;//标记节点为-1因为在后面环检测时会出现环外祖先
                System.out.println(ans1[0] + " " + ans1[1] + " " + ans2[0] + " " + ans2[1]);
                break;
            }
            uf.par[e[1]] = uf.find(e[0]);
        }
        uf = new UF(edges.length + 1);
        for (int[] e : edges) {
            if (e[1] == -1) continue;
            if (uf.find(e[0]) == e[1]) {
                System.out.println("has cycle");
                return ans1 == null ? e : ans1;
            }
            uf.par[e[1]] = e[0];
            // System.out.println(uf.par[e[1]]);
        }
        return ans2;
    }
}
