package shared.primitives;


import shared.visitors.IVisitor;

public class Triangle extends GeometricFigure2D {
    private Point2D top;
    private Point2D left;
    private Point2D right;

    public Triangle(Point2D top, Point2D left, Point2D right) {
        Line line = new Line(left, right);

        if (line.contains(top)) {
            throw new Error("Points can not be located on the same line");
        }

        this.top = top;
        this.left = left;
        this.right = right;
    }

    @Override
    public float getArea() {
        return 0;
    }

    @Override
    public void move(Distance2D d) {
        this.top.move(d);
        this.left.move(d);
        this.right.move(d);
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return "Triangle(" + this.top.toString() + "," + this.left.toString() + "," + this.right.toString() + ")";
    }
}
