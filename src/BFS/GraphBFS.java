package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    private Graph G;
    private boolean[] visited;

    private List<Integer> order = new ArrayList<>();

    public GraphBFS(Graph g) {
        G = g;
        visited = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) bfs(i);
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int e = queue.poll();
            order.add(e);

            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new AdjSet("g.txt");
        GraphBFS graphBFS = new GraphBFS(g);
        System.out.println(graphBFS.order());
    }
}
