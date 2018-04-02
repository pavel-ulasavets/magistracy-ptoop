package EditorView.ToolBar;

import EditorView.EditorModel;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
import java.util.Observable;
import java.util.Observer;

public class ToolBarController implements Observer {

    private EditorModel model = null;

    @FXML
    private VBox primitivesContainer = null;
    @FXML
    private VBox canvasButtonsContainer = null;
    @FXML
    private VBox projectButtonsContainer = null;


    // ----------- private methods

    private ButtonBase createButton(ButtonBase button, String name, EventHandler<? super MouseEvent> handler) {
        EditorModel model = this.model;
      
        button.setText(name);
        button.getStyleClass().add("tool-bar-button");
        button.setPrefWidth(150);
        button.setOnMousePressed(handler);

        return button;
    }

    private ArrayList<ButtonBase> createFiguresButtons() {
        ArrayList<ButtonBase> list = new ArrayList<>();

        HashMap<String, GeometricFigureFactory> factories = this.model.getFactories();
        ToggleGroup group = new ToggleGroup();

        for (String key: factories.keySet()) {
            GeometricFigureFactory factory = factories.get(key);
            EventHandler<? super MouseEvent> eventHandler = (EventHandler<MouseEvent>) event -> model.setActiveFigureFactory(factory);
            ToggleButton button = (ToggleButton) this.createButton(new ToggleButton(), key, eventHandler);
            boolean selected = model.getActiveFigureFactory().equals(factory);

            button.setToggleGroup(group);
            button.setSelected(selected);
            list.add(button);
        }

        return list;
    }

    private ArrayList<ButtonBase> createCanvasButtons() {
        ArrayList<ButtonBase> list = new ArrayList<>();

        // clear canvas
        EventHandler<? super MouseEvent> clearCanvasHandler = (EventHandler<MouseEvent>) event -> model.clearAll();
        list.add(this.createButton(new Button(), "Clear Canvas", clearCanvasHandler));

        return list;
    }

    private ArrayList<ButtonBase> createProjectButtons() {
        ArrayList<ButtonBase> list = new ArrayList<>();

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
        list.add(this.createButton(new Button(), "Export Project", exportHandler));

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
        list.add(this.createButton(new Button(),"Import Project", importHandler));

        return list;
    }

    private void createButtons() {
        if (this.model == null) {
            return;
        }

        this.primitivesContainer.getChildren().addAll(this.createFiguresButtons());
        this.canvasButtonsContainer.getChildren().addAll(this.createCanvasButtons());
        this.projectButtonsContainer.getChildren().addAll(this.createProjectButtons());
    }

    // ----------- public methods ---------------------

    public void setModel(EditorModel model) {
        this.model = model;
        this.model.addObserver(this);
        this.createButtons();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.canvasButtonsContainer.getChildren().setAll(createCanvasButtons());
    }
}
