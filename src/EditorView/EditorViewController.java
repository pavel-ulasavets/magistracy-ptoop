package EditorView;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import shared.DrawingTransactionByMouse;
import shared.visitors.DrawingVisitor;


public class EditorViewController {
    private EditorModel model;
    private DrawingTransactionByMouse transaction = null;
    private DrawingVisitor drawingVisitor = null;

    @FXML
    private GridPane editorPane;

    public EditorViewController() {
        this.model = new EditorModel();
    }

}
