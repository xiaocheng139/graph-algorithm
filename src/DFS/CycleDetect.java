package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;

public class CycleDetect {
    private final Graph G;
    private final boolean[] visited;
    private final int[] parent;

    public CycleDetect(Graph G) {
        this.G = G;
        parent = new int[G.V()];
        visited = new boolean[G.V()];
    }

    private boolean dfs(int v) {
        visited[v] = true;
        for (int nei: G.neighbors(v)) {
            if (!visited[nei]) {
                parent[nei] = v;
                if (dfs(nei)) return true;
            } else if (nei != parent[v]) {
               return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        for (int i = 0; i < G.V(); i++) {
            if (dfs(i)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        CycleDetect graphDFS = new CycleDetect(graph);
        System.out.println(graphDFS.hasCycle());
    }
}
