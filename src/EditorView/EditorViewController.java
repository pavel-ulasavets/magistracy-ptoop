package EditorView;

import EditorView.Canvas.CanvasController;
import EditorView.FiguresPalette.FiguresPaletteController;
import javafx.fxml.FXML;


public class EditorViewController {
    private EditorModel model;


    @FXML
    private CanvasController editorCanvasController = null;

    @FXML
    private FiguresPaletteController figuresPaletteController = null;

    @FXML
    public void initialize() {
        this.model = new EditorModel();

        this.editorCanvasController.setModel(this.model);
        this.figuresPaletteController.setModel(this.model);
    }
}
