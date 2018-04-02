package shared.visitors;


import shared.primitives.*;

public interface IVisitor {
    void visit(Circle c);

    void visit(Rectangle r);

    void visit(Line l);

    void visit (Point2D p);

    void visit (Triangle t);
}
