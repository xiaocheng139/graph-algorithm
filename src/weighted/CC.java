package weighted;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;

public class CC {
    private WeightedGraph G;
    private boolean[] visited;
    private int cccount = 0;

    public CC(WeightedGraph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                cccount++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;

        for (int nei: G.neighbors(v)) {
            if (!visited[nei]) dfs(nei);
        }
    }

    public int count() {
        return cccount;
    }
}
