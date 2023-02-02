package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Path {
    private final Graph G;
    private final int s;
    private final int t;
    private final boolean[] visited;
    private final int[] prev;

    public Path(Graph G, int s, int t) {
        this.G = G;
        this.s = s;
        this.t = t;
        prev = new int[G.V()];
        visited = new boolean[G.V()];
        System.out.println(dfs(s));
    }

    private boolean dfs(int v) {
        if (v == t) return true;
        visited[v] = true;


        for (int nei: G.neighbors(v)) {
            if (!visited[nei]) {
                prev[nei] = v;
                if (dfs(nei)) return true;
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }

    public List<Integer> getPath() {
        List<Integer> res = new ArrayList<>();
        if (!isConnected()) return res;
        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = prev[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        Path graphDFS = new Path(graph, 3, 6);
        System.out.println(graphDFS.getPath());
    }
}
