package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverALaDerecha;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class PanelDeBloques extends HBox {

    Scene scene;

    PanelDeBloques(Rectangle2D screenBounds, Scene scene){
        super();

        this.scene = scene;

        VBox vBox = inicializarVBox(screenBounds);


       ScrollPane scrollPane = new ScrollPane(vBox);

        super.setPrefHeight(screenBounds.getHeight() * 2);
        super.setPrefWidth(screenBounds.getWidth() * 0.20);
        super.setAlignment(Pos.TOP_RIGHT);
        super.setStyle("-fx-background-color: #fa9579;");

        super.getChildren().add(scrollPane);
    }

    private VBox inicializarVBox(Rectangle2D screenBounds){

        VBox vBox = new VBox();

        vBox.setPrefWidth(screenBounds.getWidth() * 0.2);
        vBox.setPrefHeight(screenBounds.getHeight() * 1.3);
        vBox.setPadding(new Insets(20,0,0, screenBounds.getHeight() * 0.1));
        vBox.setStyle("-fx-background-color: #fa9579;");

        System.out.println(vBox.getLayoutBounds());

        vBox.getChildren().add(new ImagenBloque("draw-north.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaArriba()));
        vBox.getChildren().add(new ImagenBloque("draw-south.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaAbajo()));
        vBox.getChildren().add(new ImagenBloque("draw-east.png",    screenBounds, this.scene, new ControladorBloqueMoverADerecha()));
        vBox.getChildren().add(new ImagenBloque("draw-west.png",    screenBounds, this.scene, new ControladorBloqueMoverAIzquierda()));
        vBox.getChildren().add(new ImagenBloque("bajar.png",        screenBounds, this.scene, new ControladorBloqueBajar()));
        vBox.getChildren().add(new ImagenBloque("subir.png",        screenBounds, this.scene, new ControladorBloqueSubir()));
        vBox.getChildren().add(new ImagenBloque("invertir.png",     screenBounds, this.scene, new ControladorBloqueRepeticion()));
        vBox.getChildren().add(new ImagenBloque("repeticion.png",   screenBounds, this.scene, new ControladorBloqueInversion()));

        return vBox;
    }
}
