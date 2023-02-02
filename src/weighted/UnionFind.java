package weighted;

public class UnionFind {
    private int n;
    private int[] parents;
    private int[] sizes;

    public UnionFind(int n) {
        this.n = n;
        parents = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int p) {
        if (parents[p] == p) return p;
        int root = find(parents[p]);
        parents[p] = root;
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        parents[rootP] = rootQ;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
