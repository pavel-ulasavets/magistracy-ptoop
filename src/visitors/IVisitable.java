package visitors;

public interface IVisitable<T> {
    void accept(IVisitor<T> visitor);
}
