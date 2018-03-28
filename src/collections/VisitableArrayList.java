package collections;

import visitors.IVisitable;
import visitors.IVisitor;
import java.util.ArrayList;

public class VisitableArrayList<T extends IVisitable> extends ArrayList<T> implements IVisitable {
    public void accept(IVisitor v) {
        for (IVisitable element: this) {
            element.accept(v);
        }
    }
}
