package shared.factories;

import shared.DrawingTransactionByMouse;
import shared.primitives.GeometricFigure2D;

public abstract class GeometricFigureFactory {
    public abstract GeometricFigure2D createFigure(DrawingTransactionByMouse transaction);
}
