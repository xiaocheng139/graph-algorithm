package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetect {
    private final Graph G;
    private final boolean[] visited;
    private final int[] parent;

    public CycleDetect(Graph G) {
        this.G = G;
        parent = new int[G.V()];
        visited = new boolean[G.V()];
    }



    public boolean hasCycle() {
        for (int i = 0; i < G.V(); i++) {
            if (bfs(i)) return true;
        }
        return false;
    }

    private boolean bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        parent[i] = i;
        while (!queue.isEmpty()) {
            int e = queue.poll();
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                    parent[nei] = e;
                } else if (parent[e] != nei) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        CycleDetect graphDFS = new CycleDetect(graph);
        System.out.println(graphDFS.hasCycle());
    }
}
