package core;

import collections.VisitableArrayList;
import factories.FiguresFactory;
import primitives.GeometricFigure2D;
import visitors.DrawingVisitor;


public class Main {

    public static void main(String[] args) {
        FiguresFactory factory = new FiguresFactory();
        VisitableArrayList<GeometricFigure2D> list = factory.createScreen();
        DrawingVisitor visitor = new DrawingVisitor();

        list.accept(visitor);
    }
}
