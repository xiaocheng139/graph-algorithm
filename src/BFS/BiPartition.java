package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

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
                if (!bfs(i, 0)) isBipartition = false;
                break;
            }
        }
    }

    private boolean bfs(int v, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        colors[v] = color;

        while (!queue.isEmpty()) {
            int e = queue.poll();
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                    colors[nei] = 1 - colors[e];
                } else if (colors[nei] == colors[e]) {
                    return false;
                }
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
