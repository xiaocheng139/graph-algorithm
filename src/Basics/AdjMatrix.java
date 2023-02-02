package Basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjMatrix implements Graph {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        V = scanner.nextInt();
        adj = new int[V][V];

        E = scanner.nextInt();
        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

    }

    @Override
    public boolean isConnected(int v1, int v2) {
        return adj[v1][v2] == 1;
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
    public Iterable<Integer> neighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) neighbors.add(i);
        }
        return neighbors;
    }

    @Override
    public int degree(int v) {
        return ((List<?>) neighbors(v)).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
