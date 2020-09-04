public class DSU {
    private int[] par;
    private int[] rank;

    public DSU(int size) {
        par = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) par[i] = i;
    }

    public int find(int x) {
        if (par[x] != x) par[x] = find(par[x]);
        return par[x];
    }

    public void union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return;
        if (rank[xr] < rank[yr]) par[xr] = yr;
        else {
            par[yr] = xr;
            if (rank[xr] == rank[yr]) rank[xr]++;
        }
    }
}
