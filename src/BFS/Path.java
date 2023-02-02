package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.*;

public class Path {
    private Graph G;
    private int s;
    private int e;
    private boolean[] visited;
    private int[] prev;

    public Path(Graph g, int s, int e) {
        this.G = g;
        this.s = s;
        this.e = e;
        visited = new boolean[G.V()];
        prev = new int[G.V()];
        System.out.println(bfs(s));
    }

    public boolean bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        prev[v] = v;
        if (v == e) return true;
        while (!queue.isEmpty()) {
            int e = queue.poll();
            if (e == this.e) return true;
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                    prev[nei] = e;
                }
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[e];
    }

    public List<Integer> getPath() {
        List<Integer> res = new ArrayList<>();
        if (!isConnected()) return res;
        int cur = e;
        while (cur != s) {
            res.add(cur);
            cur = prev[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new AdjSet("g.txt");
        Path path = new Path(g, 0, 6);
        System.out.println(path.getPath());
    }
}
