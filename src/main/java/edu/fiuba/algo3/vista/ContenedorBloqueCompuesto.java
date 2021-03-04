package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class ContenedorBloqueCompuesto extends HBox {
    SeccionBloquesEnAgregable bloquesDisponibles;
    SeccionAgregadosEnAgregable bloquesAgregados;
    Rectangle2D bounds;
    Scene scene;

    public ContenedorBloqueCompuesto(Scene scene, Rectangle2D bounds, BloqueAgregable bloque){
        super();
        super.setPrefWidth(bounds.getWidth());
        super.setPrefHeight(bounds.getHeight());
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        this.bounds = bounds;
        this.scene = scene;

        this.bloquesDisponibles = new SeccionBloquesEnAgregable(scene, bounds, bloque);
        this.bloquesAgregados = new SeccionAgregadosEnAgregable(scene, bounds);

        ScrollPane scrollPaneAgregables = new ScrollPane(bloquesDisponibles);
        ScrollPane scrollPaneAgregados= new ScrollPane(bloquesAgregados);


        super.getChildren().addAll(scrollPaneAgregables, scrollPaneAgregados);
    }

    public void update(Bloque bloque) {
        bloquesAgregados.update(bloque);
    }
}
