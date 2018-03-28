package primitives;

import visitors.IVisitable;
import visitors.IVisitor;

public abstract class GeometricFigure2D implements IMoveable, IVisitable<GeometricFigure2D> {
    public abstract float getArea();

    public void accept(IVisitor<GeometricFigure2D> v) {
        v.visit(this);
    }

}
