package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class CC {
    private Graph G;
    private boolean[] visited;
    private int cccount = 0;

    public CC(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                bfs(i);
                cccount++;
            }
        }
    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int e = queue.poll();
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                }
            }
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
