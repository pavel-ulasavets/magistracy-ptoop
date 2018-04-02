package EditorView.FiguresPalette;

import EditorView.EditorModel;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import shared.factories.GeometricFigureFactory;

import java.util.HashMap;

public class FiguresPaletteController {

    private EditorModel model = null;

    @FXML
    private VBox paletteButtonsContainer = null;


    // ----------- private methods

    private Button createButton(String name, GeometricFigureFactory factory) {
        EditorModel model = this.model;
        Button paletteButton = new Button(name);

        paletteButton.getStyleClass().add("palette-button");
        paletteButton.setPrefWidth(150);

        EventHandler<? super MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setActiveFigureFactory(factory);
            }
        };
        paletteButton.setOnMousePressed(eventHandler);

        return paletteButton;
    }

    private void intializeButtons() {
        if (this.model == null) {
            return;
        }

        HashMap<String, GeometricFigureFactory> factories = this.model.getFactories();

        for (String key: factories.keySet()) {
            this.paletteButtonsContainer.getChildren().add(this.createButton(key, factories.get(key)));
        }

    }

    // ----------- public methods ---------------------

    @FXML
    public void initialize() {
        this.intializeButtons();
    }

    public void setModel(EditorModel model) {
        this.model = model;
        this.intializeButtons();
    }


    // ---------- event handlers --------------

    public void onMousePressed(MouseEvent e) {
        System.out.println("on button clicked.");
    }
}
