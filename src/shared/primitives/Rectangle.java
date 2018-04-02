package shared.primitives;


import shared.visitors.IVisitor;

import java.awt.*;

public class Rectangle extends GeometricFigure2D {
    private Point2D topLeft;
    private Point2D bottomRight;


    // ------------- private methods -------------

    private boolean validatePoints(Point2D topLeft, Point2D bottomRight) {
        boolean areXsEqual = topLeft.getX() == bottomRight.getX();
        boolean areYsEqual = topLeft.getY() == bottomRight.getY();


        return !(areXsEqual || areYsEqual);
    }


    // ------------ public methods --------------

    public Rectangle(Point2D topLeft, Point2D bottomRight) throws Exception {
        if (validatePoints(topLeft, bottomRight)) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        } else {
            throw new Exception("a Rectangle can not have both points with either equal Xs or equal Ys");
        }
    }

    public Rectangle() throws Exception {
        this(new Point2D(0, 0), new Point2D(10, 10));
    }

    public int getWidth() {
        return this.bottomRight.getDistance(this.topLeft).getX();
    }


    public int getHeight() {
        return this.bottomRight.getDistance(this.topLeft).getY();
    }

    public Point2D getTopLeft() {
        return this.topLeft.clone();
    }

    public Point2D getBottomRight() {
        return this.bottomRight.clone();
    }

    public void setTopLeft(Point2D p) throws Exception {
        if (validatePoints(p, this.bottomRight)) {
            this.topLeft = p;
            return;
        }

        throw new Exception("a Rectangle can not have both points with either equal Xs or equal Ys");
    }

    public void setBottomRight(Point2D p) throws Exception {
        if (validatePoints(this.topLeft, p)) {
            this.bottomRight = p;
            return;
        }

        throw new Exception("a Rectangle can not have both points with either equal Xs or equal Ys");
    }


    @Override
    public float getArea() {
        return this.getHeight() * this.getWidth();
    }

    public void move(Distance2D d) {
        this.topLeft.move(d);
        this.bottomRight.move(d);
    }

    public boolean equals(Rectangle r) {
        return this.topLeft.equals(r.topLeft) && this.bottomRight.equals(r.bottomRight);
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return "Rectangle(" + this.topLeft.toString() + "," + this.bottomRight.toString() + ")";
    }
}
