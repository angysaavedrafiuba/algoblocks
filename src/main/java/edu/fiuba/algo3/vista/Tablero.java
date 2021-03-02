package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class Tablero extends Pane {

    public Tablero(Rectangle2D screenBounds, Algoblocks algoblocks) {
        super();
        super.setStyle("-fx-background-color: #08d9d6");
        super.getChildren().add(new ImagenPersonaje(screenBounds));
        super.getChildren().add(new VistaDibujo(screenBounds));
    }
}
