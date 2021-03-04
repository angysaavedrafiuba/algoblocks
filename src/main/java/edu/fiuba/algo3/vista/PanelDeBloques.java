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
        super.setStyle("-fx-background-color: #fa9579;");

        super.getChildren().add(scrollPane);
    }

    private VBox inicializarVBox(Rectangle2D screenBounds, RecorridoNormal recorrido){

        VBox vBox = new VBox();

        vBox.setPrefWidth(screenBounds.getWidth() * 0.2);
        vBox.setPrefHeight(screenBounds.getHeight() * 1.3);
        vBox.setPadding(new Insets(20,0,0, screenBounds.getHeight() * 0.1));
        vBox.setStyle("-fx-background-color: #fa9579;");

        System.out.println(vBox.getLayoutBounds());

        vBox.getChildren().add(new ImagenBloque("draw-north.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaArriba(recorrido)));
        vBox.getChildren().add(new ImagenBloque("draw-south.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaAbajo(recorrido)));
        vBox.getChildren().add(new ImagenBloque("draw-east.png",    screenBounds, this.scene, new ControladorBloqueMoverADerecha(recorrido)));
        vBox.getChildren().add(new ImagenBloque("draw-west.png",    screenBounds, this.scene, new ControladorBloqueMoverAIzquierda(recorrido)));
        vBox.getChildren().add(new ImagenBloque("bajar.png",        screenBounds, this.scene, new ControladorBloqueBajar(recorrido)));
        vBox.getChildren().add(new ImagenBloque("subir.png",        screenBounds, this.scene, new ControladorBloqueSubir(recorrido)));
        vBox.getChildren().add(new ImagenBloque("invertir.png",     screenBounds, this.scene, new ControladorBloqueInvertir(recorrido)));
        vBox.getChildren().add(new ImagenBloque("repeticion.png",   screenBounds, this.scene, new ControladorBloqueRepeticion(recorrido)));

        return vBox;
    }
}
