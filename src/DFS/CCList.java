package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CCList {
    private final Graph G;
    private final int[] visited;
    private int cccount = 0;

    public CCList(Graph G) {
        this.G = G;
        this.visited = new int[G.V()];
        Arrays.fill(visited, -1);
        for (int i = 0; i < G.V(); i++) {
            if (visited[i] == -1) {
                dfs(i, cccount);
                cccount++;
            }
        }
    }

    private void dfs(int v, int ccId) {
        visited[v] = ccId;
        for (int nei: G.neighbors(v)) {
            if (visited[nei] == -1) dfs(nei, ccId);
        }
    }

    public int count() {
        return cccount;
    }

    public boolean isConnected(int v, int w) {
        return visited[v] == visited[w];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        CCList cc = new CCList(graph);
        System.out.println(cc.count());
    }
}
