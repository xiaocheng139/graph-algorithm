package weighted;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    private WeightedGraph G;
    private List<WeightedEdge> mst;

    public Kruskal(WeightedGraph g) {
        G = g;
        mst = new ArrayList<>();
        CC cc = new CC(G);
        if (cc.count() > 1) return;
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        for (int v = 0; v < G.V(); v++) {
            for (int w: G.neighbors(v)) {
                if (v < w) {
                    edges.add(new WeightedEdge(v, w, G.getWeight(v, w)));
                }
            }
        }
        Collections.sort(edges);
        UnionFind uf = new UnionFind(G.V());
        for (WeightedEdge e: edges) {
            int v = e.getV(), w = e.getW();
            if (!uf.isConnected(v, w)) {
                mst.add(e);
                uf.union(v, w);
            }
        }
    }

    public List<WeightedEdge> result() {
        return mst;
    }

    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph graph = new WeightedGraph("g_w.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal.result());
    }
}
