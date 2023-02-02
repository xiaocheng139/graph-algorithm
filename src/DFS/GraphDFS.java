package DFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    private List<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) dfs(i);
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int e = stack.pop();
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    order.add(nei);
                    stack.push(nei);
                }
            }
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new AdjSet("g.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        Iterable<Integer> order = graphDFS.getOrder();
        System.out.println(order);
    }
}
