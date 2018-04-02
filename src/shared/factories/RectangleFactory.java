package shared.factories;

import javafx.scene.input.MouseEvent;
import shared.DrawingTransactionByMouse;
import shared.primitives.*;

public class RectangleFactory extends GeometricFigureFactory {
    public GeometricFigure2D createFigure(DrawingTransactionByMouse transaction) throws Exception {
        MouseEvent startEvent = transaction.getStartEvent();
        MouseEvent endEvent = transaction.getEndEvent();

        Point2D topLeft = new Point2D((int) startEvent.getX(),  (int) startEvent.getY());
        Point2D bottomRight = new Point2D((int) endEvent.getX(), (int) endEvent.getY());

        return new Rectangle(topLeft, bottomRight);
    }
}
