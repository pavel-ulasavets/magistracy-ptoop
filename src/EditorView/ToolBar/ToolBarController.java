package EditorView.ToolBar;

import EditorView.EditorModel;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import shared.factories.GeometricFigureFactory;

import java.util.HashMap;

public class ToolBarController {

    private EditorModel model = null;

    @FXML
    private VBox paletteButtonsContainer = null;


    // ----------- private methods

    private Button createButton(String name, EventHandler<? super MouseEvent> handler) {
        EditorModel model = this.model;
        Button paletteButton = new Button(name);

        paletteButton.getStyleClass().add("palette-button");
        paletteButton.setPrefWidth(150);
        paletteButton.setOnMousePressed(handler);

        return paletteButton;
    }

    private void createButtons() {
        if (this.model == null) {
            return;
        }

        // create palette buttons

        HashMap<String, GeometricFigureFactory> factories = this.model.getFactories();

        for (String key: factories.keySet()) {
            GeometricFigureFactory factory = factories.get(key);
            EventHandler<? super MouseEvent> eventHandler = (EventHandler<MouseEvent>) event -> model.setActiveFigureFactory(factory);
            this.paletteButtonsContainer.getChildren().add(this.createButton(key, eventHandler));
        }

        // create clear canvas button

        EventHandler<? super MouseEvent> eventHandler = (EventHandler<MouseEvent>) event -> model.clearAll();
        this.paletteButtonsContainer.getChildren().add(this.createButton("Clear Canvas", eventHandler));

    }

    // ----------- public methods ---------------------

    public void setModel(EditorModel model) {
        this.model = model;
        this.createButtons();
    }

}
