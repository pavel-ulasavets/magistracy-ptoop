package shared.primitives;


import shared.visitors.IVisitor;

public class Point2D extends GeometricFigure2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this(0, 0);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public float getArea() {
        return 0;
    }

    public Distance2D getDistance(Point2D p) {
        return new Distance2D(p.getX() - this.x, p.getY() - this.y);
    }

    @Override
    public void move(Distance2D d) {
        this.x += d.getX();
        this.y += d.getY();
    }

    public boolean equals(Point2D p) {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return "Point2D(" + this.x + "," + this.y + ")";
    }

    public Point2D clone() {
        return new Point2D(this.getX(), this.getY());
    }
}
