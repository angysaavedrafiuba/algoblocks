package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Personaje;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Tablero extends StackPane {
    public Tablero(Rectangle2D screenBounds) {
        super();
        super.setStyle("-fx-background-color: #08d9d6");
        super.getChildren().add(new ImagenPersonaje());
    }
}
