package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelDeBloques extends HBox {

    Scene scene;

    PanelDeBloques(Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido){
        super();

        this.scene = scene;

        VBox vBox = inicializarVBox(screenBounds, recorrido);


       ScrollPane scrollPane = new ScrollPane(vBox);

        super.setPrefHeight(screenBounds.getHeight() * 2);
        super.setPrefWidth(screenBounds.getWidth() * 0.20);
        super.setAlignment(Pos.TOP_RIGHT);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        super.getChildren().add(scrollPane);
    }

    private VBox inicializarVBox(Rectangle2D screenBounds, RecorridoNormal recorrido){

        VBox vBox = new VBox();

        vBox.setPrefWidth(screenBounds.getWidth() * 0.2);
        vBox.setPrefHeight(screenBounds.getHeight() * 1.3);
        vBox.setPadding(new Insets(20,0,0, screenBounds.getHeight() * 0.1));
        vBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        AgregadorBloques.agregarBloques(vBox, screenBounds, scene, recorrido);

        return vBox;
    }
}
