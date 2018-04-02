package shared.primitives;

import shared.visitors.IVisitor;

public class Circle extends GeometricFigure2D {

    private Point2D center;
    private int radius;

    public Circle() {
        super();
    }

    public Circle(Point2D center, int radius) {
        if (radius <= 0) {
            throw new Error("radius should be a positive number");
        }

        this.center = center;
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(this.radius, 2));
    }

    public Point2D getCenter() {
        return this.center;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setCenter(Point2D p) {
        this.center = p;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void move(Distance2D d) {
        this.center.move(d);
    }

    public boolean equals(Circle c) {
        return this.center.equals(c) && this.radius == c.radius;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return "Circle(" + this.center.toString() + "," + this.radius + ")";
    }
}
