package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.listeners.ControladorPersonaje;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

public class Tablero extends Pane {

    public Tablero(Rectangle2D screenBounds, Algoblocks algoblocks) {
        super();
        super.setStyle("-fx-background-color: #08d9d6");
        VistaDibujo vistaDibujo = new VistaDibujo(screenBounds);
        ImagenPersonaje imagenPersonaje = new ImagenPersonaje(screenBounds, vistaDibujo.getControladorDibujo());
        super.getChildren().add(vistaDibujo);
        super.getChildren().add(imagenPersonaje);
    }
}
