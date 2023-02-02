package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleSourcePath {
    private final Graph G;
    private final int s;
    private final int[] prev;

    public SingleSourcePath(Graph G, int s) {
        this.G = G;
        this.s = s;
        prev = new int[G.V()];
        Arrays.fill(prev, -1);
        dfs(s);
    }

    private void dfs(int v) {
        for (int nei: G.neighbors(v)) {
            if (prev[nei] == -1) {
                prev[nei] = v;
                dfs(nei);
            }
        }
    }

    public boolean isConnected(int v) {
        return prev[v] != -1;
    }

    public List<Integer> getPath(int v) {
        List<Integer> res = new ArrayList<>();
        if (!isConnected(v)) return res;
        while (v != s) {
            res.add(v);
            v = prev[v];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        SingleSourcePath graphDFS = new SingleSourcePath(graph, 3);
        System.out.printf("%s - %s: %s", 3, 6, graphDFS.getPath(6));
    }
}
