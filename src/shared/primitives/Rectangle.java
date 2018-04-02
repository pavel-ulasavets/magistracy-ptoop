package shared.primitives;


import shared.visitors.IVisitor;

public class Rectangle extends GeometricFigure2D {
    private Point2D topLeft;
    private Point2D bottomRight;


    public Rectangle(Point2D topLeft, Point2D bottomRight) {
        if (topLeft.getX() >= bottomRight.getX()) {
            throw new Error("topLeft.x can not be >= than bottomRight.x ");
        }

        if (topLeft.getY() >=  bottomRight.getY()) {
            throw new Error("topLeft.y can not be >= than bottomRight.y");
        }


        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
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
