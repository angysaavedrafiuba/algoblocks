package edu.fiuba.algo3.vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Tablero extends Pane {

    public Tablero(Rectangle2D screenBounds) {
        super();
        super.setStyle("-fx-background-color: " + Colores.CELESTE + ";");
        VistaDibujo vistaDibujo = new VistaDibujo(screenBounds);
        ImagenPersonaje imagenPersonaje = new ImagenPersonaje(screenBounds, vistaDibujo.getControladorDibujo());

        super.getChildren().add(vistaDibujo);
        super.getChildren().add(imagenPersonaje);
    }
}
