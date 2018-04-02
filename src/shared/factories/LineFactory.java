package shared.factories;

import javafx.scene.input.MouseEvent;
import shared.DrawingTransactionByMouse;
import shared.primitives.*;
import shared.primitives.GeometricFigure2D;


public class LineFactory extends GeometricFigureFactory {
    public GeometricFigure2D createFigure(DrawingTransactionByMouse transaction) {
        MouseEvent startEvent = transaction.getStartEvent();
        MouseEvent endEvent = transaction.getEndEvent();

        Point2D a = new Point2D((int) startEvent.getX(),  (int) startEvent.getY());
        Point2D b = new Point2D((int) endEvent.getX(), (int) endEvent.getY());

        return new Line(a, b);
    }
}
