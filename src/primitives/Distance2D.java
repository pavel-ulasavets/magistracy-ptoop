package primitives;

public class Distance2D {
    private int x;
    private int y;


    public Distance2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Distance2D d) {
        return Math.abs(this.x) == Math.abs(d.x) && Math.abs(this.y) == Math.abs(d.y);
    }

    public Distance2D sum(Distance2D d) {
        return new Distance2D(this.x + d.x, this.y + d.y);
    }
}
