package shared.visitors;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shared.primitives.*;

public class DrawingVisitor implements IVisitor {
    private GraphicsContext gc;

    public DrawingVisitor(GraphicsContext gc) {
        this.gc = gc;
    }

    public void visit(Circle c) {
        Point2D center = c.getCenter();
        int radius = c.getRadius();


        this.gc.setLineWidth(2);
        this.gc.setStroke(Color.BLACK);
        this.gc.setFill(Color.WHITE);
        this.gc.strokeOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }

    public void visit(Triangle t) {

    }

    public void visit(Rectangle r) {
        Point2D topLeft = r.getTopLeft();
        Point2D bottomRight = r.getBottomRight();
        int w = bottomRight.getX() - topLeft.getX();
        int h = bottomRight.getY() - topLeft.getY();

        this.gc.strokeRect(topLeft.getX(), topLeft.getY(), w, h);
    }

    public void visit(Line l) {
        Point2D a = l.getStartPoint();
        Point2D b = l.getEndPoint();

        this.gc.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public void visit(Point2D p) {

    }
}
