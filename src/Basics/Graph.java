package Basics;

public interface Graph {
    Iterable<Integer> neighbors(int v);

    int degree(int v);

    boolean isConnected(int v1, int v2);

    int V();

    int E();
}
