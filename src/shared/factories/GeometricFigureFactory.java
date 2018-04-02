package shared.factories;

import shared.DrawingTransactionByMouse;
import shared.primitives.GeometricFigure2D;

import java.util.HashMap;

public abstract class GeometricFigureFactory {
    public abstract GeometricFigure2D createFigure(DrawingTransactionByMouse transaction) throws Exception;

    @Override
    public boolean equals(Object factory) {
        return this.getClass() == factory.getClass();
    }
}
