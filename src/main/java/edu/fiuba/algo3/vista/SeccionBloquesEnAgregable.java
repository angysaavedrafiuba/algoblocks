package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SeccionBloquesEnAgregable extends Pane {
    final VBox vBox;
    public SeccionBloquesEnAgregable(Scene scene, Rectangle2D bounds, BloqueAgregable bloque) {
        this.vBox = new VBox();

        VBox contenedorPrincipal = new VBox();

        super.setPrefWidth(bounds.getWidth() * 0.5);
        super.setPrefHeight(bounds.getHeight() * 3);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");


        this.vBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        this.vBox.setAlignment(Pos.TOP_RIGHT);
        this.vBox.setAlignment(Pos.TOP_CENTER);
        this.vBox.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.16));
        this.vBox.setPrefWidth(bounds.getWidth() * 0.5);
        this.vBox.setPrefHeight(bounds.getHeight() * 1.8);


        Label descripcion = new Label();
        descripcion.setText("Bloques disponibles");
        descripcion.setFont(new Font(30));
        descripcion.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.09));

        AgregadorBloques.agregarBloques(this.vBox, new Rectangle2D(0, 0, 1500, 1000), scene, bloque.getRecorrido());

        contenedorPrincipal.getChildren().addAll(descripcion, this.vBox);

        super.getChildren().add(contenedorPrincipal);
    }
}
