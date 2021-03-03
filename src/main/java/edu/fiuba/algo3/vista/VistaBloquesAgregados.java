package edu.fiuba.algo3.vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;


public class VistaBloquesAgregados extends ScrollPane {
    Scene scene;
    private final Rectangle2D bounds;
    private HBox box;

    public VistaBloquesAgregados(Rectangle2D screenBounds, Scene scene) {
        super();
        this.scene = scene;
        this.bounds = screenBounds;

        this.box = new HBox();
        super.getChildren().add(this.box);
        super.setStyle("-fx-background-color: #ff2e63;");
    }

    public void agregarBloque(ImagenConComportamiento imagenConComportamiento) {
        this.box.getChildren().add(imagenConComportamiento);
    }

    public void limpiar() {
        this.box.getChildren().clear();
    }
}
