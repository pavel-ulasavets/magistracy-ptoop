package visitors;


import primitives.GeometricFigure2D;

public class DrawingVisitor implements IVisitor<GeometricFigure2D> {
    public void visit(GeometricFigure2D drawable) {
        System.out.println(drawable.toString());
    }
}
