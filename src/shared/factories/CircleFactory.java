package shared.factories;

import javafx.scene.input.MouseEvent;
import shared.DrawingTransactionByMouse;
import shared.primitives.Circle;
import shared.primitives.GeometricFigure2D;
import shared.primitives.Point2D;


public class CircleFactory extends GeometricFigureFactory {

    public GeometricFigure2D createFigure(DrawingTransactionByMouse transaction) {
        MouseEvent startEvent = transaction.getStartEvent();
        MouseEvent endEvent = transaction.getEndEvent();

        double deltaX = endEvent.getX() - startEvent.getX();
        double deltaY = endEvent.getY() - startEvent.getY();
        double radius = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        return new Circle(new Point2D((int) startEvent.getX(), (int) startEvent.getY()), (int) radius);
    }
}
