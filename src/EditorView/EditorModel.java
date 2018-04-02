package EditorView;

import shared.DrawingTransactionByMouse;
import shared.factories.*;
import shared.factories.GeometricFigureFactory;
import shared.primitives.GeometricFigure2D;
import shared.collections.*;
import shared.visitors.IVisitable;
import shared.visitors.IVisitor;

import java.util.HashMap;
import java.util.Observable;

public class EditorModel extends Observable implements IVisitable {

    // ----------- private properties ----------------

    private VisitableArrayList<GeometricFigure2D> figures;
    private GeometricFigureFactory activeFigureFactory;

    // ----------- private methods -------------------

    private void sendMessage() {
        this.setChanged();
        this.notifyObservers();
    }


    // ----------- public methods --------------------


    public EditorModel() {
        this.figures = new VisitableArrayList<>();
        this.activeFigureFactory = new LineFactory();
    }

    /**
     * creates a figure by a given mouse transaction using
     * an active figure factory
     */
    public void createFigureByTransaction(DrawingTransactionByMouse transaction) {
        this.figures.add(this.activeFigureFactory.createFigure(transaction));
        this.sendMessage();
    }

    /**
     * accept an operation provided by a given visitor for the whole collection of figures
     */
    public void accept(IVisitor v) {
        this.figures.accept(v);
    }

    /**
     * clears the list of existing figures
     */
    public void clearAll() {
        this.figures.clear();
        this.sendMessage();
    }

    /**
     * changes an active factory to one specified
     */
    public void setActiveFigureFactory(GeometricFigureFactory factory) {
        this.activeFigureFactory = factory;
    }

    /**
     * builds the list of factories supported in the system
     * TODO: think of capability to move this code outside
     */
    public HashMap<String, GeometricFigureFactory> getFactories() {
        HashMap<String, GeometricFigureFactory> factoriesMap = new HashMap<>();

        factoriesMap.put("Circle", new CircleFactory());
        factoriesMap.put("Line", new LineFactory());
        factoriesMap.put("Rectangle", new RectangleFactory());

        return factoriesMap;
    }

}
