package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class ContenedorBloqueCompuesto extends HBox {
    SeccionBloquesEnAgregable bloquesDisponibles;
    SeccionAgregadosEnAgregable bloquesAgregados;
    Scene scene;

    public ContenedorBloqueCompuesto(){
        super();
    }

    public void inicializar(Rectangle2D bounds, Scene escena, BloqueAgregable bloque){
        super.setPrefWidth(bounds.getWidth());
        super.setPrefHeight(bounds.getHeight());
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        this.scene = escena;

        this.bloquesDisponibles = new SeccionBloquesEnAgregable(scene, bounds, bloque);
        this.bloquesAgregados = new SeccionAgregadosEnAgregable(scene, bounds, bloque);

        ScrollPane scrollPaneAgregables = new ScrollPane(bloquesDisponibles);
        ScrollPane scrollPaneAgregados= new ScrollPane(bloquesAgregados);


        super.getChildren().addAll(scrollPaneAgregables, scrollPaneAgregados);
    }

    public void update(Bloque bloque) {
        bloquesAgregados.update(bloque);
    }

}
