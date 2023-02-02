package Basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList implements Graph {
    private final int V;
    private final int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        V = scanner.nextInt();
        E = scanner.nextInt();
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    @Override
    public Iterable<Integer> neighbors(int v) {
        return adj[v];
    }

    @Override
    public int degree(int v) {
        return adj[v].size();
    }

    @Override
    public boolean isConnected(int v1, int v2) {
        return adj[v1].contains(v2);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int n: adj[i]) {
                sb.append(String.format("%d ", n));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph adjMatrix = new AdjList("g.txt");
        System.out.println(adjMatrix);
    }
}
