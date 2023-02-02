package weighted;

public class WeightedEdge implements Comparable<WeightedEdge>{
    private int v, w, wight;

    public WeightedEdge(int v, int w, int wight) {
        this.v = v;
        this.w = w;
        this.wight = wight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("(%d-%d: %d)", v, w, wight);
    }

    @Override
    public int compareTo(WeightedEdge another) {
        return wight - another.wight;
    }
}
