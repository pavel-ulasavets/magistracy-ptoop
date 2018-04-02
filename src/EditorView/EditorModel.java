package EditorView;

import shared.DrawingTransactionByMouse;
import shared.factories.*;
import shared.factories.GeometricFigureFactory;
import shared.primitives.GeometricFigure2D;
import shared.collections.*;
import shared.visitors.IVisitable;
import shared.visitors.IVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public void setActiveFigureFactory(GeometricFigureFactory factory) {
        this.activeFigureFactory = factory;
    }

    public HashMap<String, GeometricFigureFactory> getFactories() {
        HashMap<String, GeometricFigureFactory> factoriesMap = new HashMap<>();

        factoriesMap.put("Circle", new CircleFactory());
        factoriesMap.put("Line", new LineFactory());
        factoriesMap.put("Rectangle", new RectangleFactory());

        return factoriesMap;
    }

    public void accept(IVisitor v) {
        this.figures.accept(v);
    }

}
