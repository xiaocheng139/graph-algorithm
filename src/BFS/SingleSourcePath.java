package BFS;

import Basics.AdjSet;
import Basics.Graph;

import java.io.FileNotFoundException;
import java.util.*;

public class SingleSourcePath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] prev;

    public SingleSourcePath(Graph g, int s) {
        this.G = g;
        this.s = s;
        visited = new boolean[G.V()];
        prev = new int[G.V()];
        Arrays.fill(prev, -1);

        bfs(s);
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        prev[v] = v;
        while (!queue.isEmpty()) {
            int e = queue.poll();
            for (int nei: G.neighbors(e)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                    prev[nei] = e;
                }
            }
        }
    }

    public boolean isConnected(int t) {
        return visited[t];
    }

    public List<Integer> getPath(int v) {
        List<Integer> res = new ArrayList<>();
        if (!isConnected(v)) return res;
        int cur = v;
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
        SingleSourcePath singleSourcePath = new SingleSourcePath(g, 0);
        System.out.println(singleSourcePath.getPath(6));
    }
}
