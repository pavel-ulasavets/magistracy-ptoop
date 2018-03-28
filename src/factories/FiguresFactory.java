package factories;

import collections.VisitableArrayList;
import primitives.*;


public class FiguresFactory {

    public VisitableArrayList<GeometricFigure2D> createList() {
        return new VisitableArrayList<GeometricFigure2D>();
    }

    public Point2D createPoint(int x, int y) {
        return new Point2D(x, y);
    }

    public Line createLine(Point2D a, Point2D b) {
        return new Line(a, b);
    }

    public Circle createCircle(Point2D center, int radius) {
        return new Circle(center, radius);
    }

    public Rectangle createRectangle(Point2D topLeft, Point2D bottomRight) {
        return new Rectangle(topLeft, bottomRight);
    }

    public Triangle createTriangle(Point2D top, Point2D left, Point2D right) {
        return new Triangle(top, left, right);
    }

    public VisitableArrayList<GeometricFigure2D> createScreen() {
        VisitableArrayList<GeometricFigure2D> list = this.createList();

        list.add(this.createRectangle(this.createPoint(0, 0), this.createPoint(1280, 720)));
        list.add(this.createCircle(this.createPoint(50, 50), 40));
        list.add(this.createRectangle(this.createPoint(0, 0), this.createPoint(50, 50)));

        // triangle
        Point2D top = this.createPoint(450, 450);
        Point2D left = this.createPoint(150, 800);
        Point2D right = this.createPoint(750, 800);


        list.add(this.createTriangle(top, left, right));

        return list;
    }

}
