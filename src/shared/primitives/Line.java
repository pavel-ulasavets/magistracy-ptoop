package shared.primitives;

import shared.visitors.IVisitor;

public class Line extends GeometricFigure2D {
    private Point2D startPoint;
    private Point2D endPoint;

    public Line() {
        super();
    }

    public Line(Point2D a, Point2D b) {
        if (a.equals(b)) {
            throw new Error("Point a should be different than point b");
        }

        this.startPoint = a;
        this.endPoint = b;
    }

    public boolean contains(Point2D p) {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY =  endPoint.getY() - startPoint.getY();

        return (p.getX() - startPoint.getX()) * deltaY == ((p.getY() - startPoint.getY()) * deltaX);
    }

    public void move(Distance2D d) {
        this.startPoint.move(d);
        this.endPoint.move(d);
    }

    @Override
    public float getArea() {
        return 0;
    }

    public Point2D getStartPoint() {
        return this.startPoint;
    }

    public void setStartPoint(Point2D p) {
        this.startPoint = p;
    }

    public Point2D getEndPoint() {
        return this.endPoint;
    }

    public void setEndPoint(Point2D p) {
        this.endPoint = p;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY =  endPoint.getY() - startPoint.getY();

        return "(x - " + startPoint.getX() + ") / " + deltaX + " = " + "(y - " + startPoint.getY() + ") / " + deltaY;
    }
}
