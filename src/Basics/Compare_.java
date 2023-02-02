package Basics;

import java.util.ArrayDeque;
import java.util.Deque;

public class Compare_ {
    private Graph g;
    private boolean[] visited;

    public Compare_(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
    }

    public void dfs1(int v) {
        visited[v] = true;
        for (int nei: g.neighbors(v)) {
            if (!visited[nei]) dfs1(nei);
        }
    }

    public void dfs2(int v) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int e = stack.pop();
            for (int nei: g.neighbors(e)) {
                if (!visited[nei]) {
                    stack.push(nei);
                    visited[nei] = true;
                }
            }
        }
    }
}
