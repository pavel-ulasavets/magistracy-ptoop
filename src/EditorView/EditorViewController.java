package EditorView;

import EditorView.Canvas.CanvasController;
import EditorView.ToolBar.ToolBarController;
import javafx.fxml.FXML;


public class EditorViewController {
    private EditorModel model;

    @FXML
    private CanvasController editorCanvasController = null;

    @FXML
    private ToolBarController toolBarController = null;

    @FXML
    public void initialize() {
        this.model = new EditorModel();

        this.editorCanvasController.setModel(this.model);
        this.toolBarController.setModel(this.model);
    }
}
