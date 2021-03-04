package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class Botonera extends HBox {

    Botonera(Rectangle2D screenBounds, Scene scene){
        super();
        super.setPrefWidth(screenBounds.getWidth() * 0.2);
        BotonPlay botonPlay = new BotonPlay(screenBounds, scene);
        BotonTacho botonReiniciar = new BotonTacho(screenBounds, scene);
        BotonReset botonReset = new BotonReset(screenBounds, scene);
        super.getChildren().addAll(botonPlay, botonReiniciar, botonReset);
        super.setPadding(new Insets(screenBounds.getHeight() * 0.05, 0, 0, screenBounds.getWidth() * 0.045));
    }
}
