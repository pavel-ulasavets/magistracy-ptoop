package EditorView.ToolBar;

import EditorView.EditorModel;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import shared.XMLSerializer;
import shared.collections.VisitableArrayList;
import shared.factories.GeometricFigureFactory;
import shared.primitives.GeometricFigure2D;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ToolBarController {

    private EditorModel model = null;

    @FXML
    private VBox canvasButtonsContainer = null;
    @FXML
    private VBox projectButtonsContainer = null;


    // ----------- private methods

    private Button createButton(String name, EventHandler<? super MouseEvent> handler) {
        EditorModel model = this.model;
        Button paletteButton = new Button(name);

        paletteButton.getStyleClass().add("tool-bar-button");
        paletteButton.setPrefWidth(150);
        paletteButton.setOnMousePressed(handler);

        return paletteButton;
    }

    private ArrayList<Button> createFiguresButtons() {
        ArrayList<Button> list = new ArrayList<>();

        HashMap<String, GeometricFigureFactory> factories = this.model.getFactories();

        for (String key: factories.keySet()) {
            GeometricFigureFactory factory = factories.get(key);
            EventHandler<? super MouseEvent> eventHandler = (EventHandler<MouseEvent>) event -> model.setActiveFigureFactory(factory);
            list.add(this.createButton(key, eventHandler));
        }

        return list;
    }

    private ArrayList<Button> createCanvasButtons() {
        ArrayList<Button> list = new ArrayList<>();

        list.addAll(this.createFiguresButtons());

        // clear canvas
        EventHandler<? super MouseEvent> clearCanvasHandler = (EventHandler<MouseEvent>) event -> model.clearAll();
        list.add(this.createButton("Clear Canvas", clearCanvasHandler));

        return list;
    }

    private ArrayList<Button> createProjectButtons() {
        ArrayList<Button> list = new ArrayList<>();

        // export
        EventHandler<? super MouseEvent> exportHandler = (EventHandler<MouseEvent>) event -> {
            FileChooser chooser = new FileChooser();
            Stage stage = (Stage) canvasButtonsContainer.getScene().getWindow();

            chooser.setTitle("Choose file for export:");
            chooser.setInitialFileName("~/Downloads/project.xml");
            File file = chooser.showSaveDialog(stage);

            if (file != null) {
                try {
                    XMLSerializer.serializeToXMLFile(this.model.getFigures(), file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        };
        list.add(this.createButton("Export Project", exportHandler));

        // export
        EventHandler<? super MouseEvent> importHandler = (EventHandler<MouseEvent>) event -> {
            FileChooser chooser = new FileChooser();
            Stage stage = (Stage) canvasButtonsContainer.getScene().getWindow();

            chooser.setTitle("Choose file for import:");
            File file = chooser.showOpenDialog(stage);

            if (file != null) {
                try {
                    VisitableArrayList<GeometricFigure2D> figures = (VisitableArrayList<GeometricFigure2D>) XMLSerializer.deserializeXML(file.getAbsolutePath());
                    this.model.setFigures(figures);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        list.add(this.createButton("Import Project", importHandler));

        return list;
    }

    private void createButtons() {
        if (this.model == null) {
            return;
        }

        this.canvasButtonsContainer.getChildren().addAll(this.createCanvasButtons());
        this.projectButtonsContainer.getChildren().addAll(this.createProjectButtons());
    }

    // ----------- public methods ---------------------

    public void setModel(EditorModel model) {
        this.model = model;
        this.createButtons();
    }

}
