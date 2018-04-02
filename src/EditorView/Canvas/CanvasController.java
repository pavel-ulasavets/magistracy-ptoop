package EditorView.Canvas;

import EditorView.EditorModel;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import shared.DrawingTransactionByMouse;
import shared.visitors.DrawingVisitor;

import java.util.Observable;
import java.util.Observer;


public class CanvasController implements Observer {
    private EditorModel model;
    private DrawingTransactionByMouse transaction = null;
    private DrawingVisitor drawingVisitor = null;

    @FXML
    private Canvas editorCanvas;
    private GraphicsContext gc;

    @FXML
    void initialize() {
        this.gc = editorCanvas.getGraphicsContext2D();
        this.drawingVisitor = new DrawingVisitor(this.gc);
    }

    public void setModel(EditorModel model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void onCanvasMousePressed(MouseEvent event) {
        if (this.transaction == null) {
            this.transaction = new DrawingTransactionByMouse();
            this.transaction.open(event);
        }
    }
    public void onCanvasMouseReleased(MouseEvent event) {
        if (this.transaction != null) {
            this.transaction.close(event);
            this.model.createFigureByTransaction(this.transaction);
            this.transaction = null;
        }
    }

    public void onCanvasMouseMoved(MouseEvent event) {

    }

    @Override
    public void update(Observable o, Object arg) {
        this.gc.clearRect(0, 0, 1280, 720);
        this.model.accept(this.drawingVisitor);
    }
}
