package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;

public class CC {
    private Graph G;
    private boolean[] visited;
    private int cccount = 0;

    public CC(Graph G) {
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

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        CC cc = new CC(graph);
        System.out.println(cc.count());
    }
}
