package shared.primitives;

import shared.visitors.IVisitable;

public abstract class GeometricFigure2D implements IMoveable, IVisitable {
    public abstract float getArea();
}
