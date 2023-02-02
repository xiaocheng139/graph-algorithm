package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;

public class BiPartition {
    private final Graph G;
    private final boolean[] visited;
    private final int[] colors;
    private boolean isBipartition;

    public BiPartition(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        isBipartition = true;

        for (int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }

        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) isBipartition = false;
                break;
            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int nei: G.neighbors(v)) {
            if (!visited[nei]) {
                if (!dfs(nei, 1 - color)) return false;
            } else if (colors[nei] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartition() {
        return isBipartition;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        BiPartition graphDFS = new BiPartition(graph);
        System.out.println(graphDFS.isBipartition());
    }
}
