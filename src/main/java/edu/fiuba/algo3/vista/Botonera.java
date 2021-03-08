package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class Botonera extends HBox {

    private static final double PROPORCION = 0.045;

    Botonera(Rectangle2D screenBounds, Scene scene){
        super();
        super.setPrefWidth(screenBounds.getWidth() * 0.2);
        BotonPlay botonPlay = new BotonPlay(screenBounds, scene, PROPORCION);
        BotonTacho botonReiniciar = new BotonTacho(screenBounds, scene, PROPORCION);
        BotonReset botonReset = new BotonReset(screenBounds, scene, PROPORCION);
        BotonAyuda botonAyuda = new BotonAyuda(screenBounds, scene, PROPORCION);
        BotonGuardarAlgoritmo botonGuardar = new BotonGuardarAlgoritmo(screenBounds, scene, PROPORCION);
        super.getChildren().addAll(botonPlay, botonReiniciar, botonReset, botonAyuda, botonGuardar);
        super.setPadding(new Insets(screenBounds.getHeight() * 0.06, 0, 0, screenBounds.getWidth() * 0.01));
    }
}
