package weighted;

import Basics.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedGraph{
    private final int V;
    private final int E;
    private Map<Integer, Integer>[] adj;

    public WeightedGraph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        V = scanner.nextInt();
        E = scanner.nextInt();
        adj = new TreeMap[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new TreeMap<>();
        }

        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt(), weight = scanner.nextInt();
            if (a == b) throw new IllegalArgumentException("Self loop is detected");
            adj[a].put(b, weight);
            adj[b].put(a, weight);
        }
    }

    public Iterable<Integer> neighbors(int v) {
        return adj[v].keySet();
    }

    public int getWeight(int v, int w) {
        return adj[v].get(w);
    }

    public int degree(int v) {
        return ((List<?>) neighbors(v)).size();
    }

    public boolean isConnected(int v1, int v2) {
        return adj[v1].containsKey(v2);
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int n: adj[i].keySet()) {
                sb.append(String.format("%d ", n));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph adjMatrix = new WeightedGraph("g_w.txt");
        System.out.println(adjMatrix);
    }
}
