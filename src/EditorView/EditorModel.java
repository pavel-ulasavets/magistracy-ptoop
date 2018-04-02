package EditorView;

import shared.DrawingTransactionByMouse;
import shared.factories.*;
import shared.factories.GeometricFigureFactory;
import shared.primitives.GeometricFigure2D;
import shared.collections.*;
import shared.visitors.IVisitable;
import shared.visitors.IVisitor;

public class EditorModel implements IVisitable {

    private VisitableArrayList<GeometricFigure2D> figures;
    private GeometricFigureFactory activeFigureFactory;

    public EditorModel() {
        this.figures = new VisitableArrayList<>();
        this.activeFigureFactory = new LineFactory();
    }

    public void addFigure(DrawingTransactionByMouse transaction) {
        this.figures.add(this.activeFigureFactory.createFigure(transaction));
    }

    public void accept(IVisitor v) {
        this.figures.accept(v);
    }

    public void clear() {
        this.figures.clear();
    }

    public void removeAllSelected() {
        // TODO: to be implemented
    }

}
