package primitives;

public class Line extends GeometricFigure2D {
    private Point2D a;
    private Point2D b;

    public Line(Point2D a, Point2D b) {
        if (a.equals(b)) {
            throw new Error("Point a should be different than point b");
        }

        this.a = a;
        this.b = b;
    }

    public boolean contains(Point2D p) {
        int deltaX = b.getX() - a.getX();
        int deltaY =  b.getY() - a.getY();

        return (p.getX() - a.getX()) * deltaY == ((p.getY() - a.getY()) * deltaX);
    }

    public void move(Distance2D d) {
        this.a.move(d);
        this.b.move(d);
    }

    @Override
    public float getArea() {
        return 0;
    }

    public String toString() {
        int deltaX = b.getX() - a.getX();
        int deltaY =  b.getY() - a.getY();

        return "(x - " + a.getX() + ") / " + deltaX + " = " + "(y - " + a.getY() + ") / " + deltaY;
    }
}
