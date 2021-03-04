package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SeccionBloquesEnAgregable extends Pane {
    VBox vBox;
    public SeccionBloquesEnAgregable(Scene scene, Rectangle2D bounds, BloqueAgregable bloque) {
        this.vBox = new VBox();

        super.setPrefWidth(bounds.getWidth() * 0.5);
        super.setPrefHeight(bounds.getHeight() * 3);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");


        this.vBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        this.vBox.setPrefHeight(bounds.getHeight() * 2);
        this.vBox.setAlignment(Pos.TOP_RIGHT);
        this.vBox.setAlignment(Pos.TOP_CENTER);
        this.vBox.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.17));
        this.vBox.setPrefWidth(bounds.getWidth() * 0.5);


        AgregadorBloques.agregarBloques(this.vBox, new Rectangle2D(0, 0, 1500, 1000), scene, bloque.getRecorrido());

        super.getChildren().add(this.vBox);
    }
}
