package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPlayHandler;
import edu.fiuba.algo3.listeners.ControladorAlgoritmo;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class PanelAlgoritmo extends HBox {

    Scene scene;
    ControladorAlgoritmo controladorAlgoritmo = new ControladorAlgoritmo();
    Algoblocks algoblocks = Algoblocks.getInstance();

    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene, Algoblocks algoblocks){
        super();
        this.scene = scene;
        ImagenConComportamiento botonPlay = new ImagenConComportamiento("play-button.png", screenBounds, scene);
        botonPlay.setOnAction(new BotonPlayHandler());
        super.getChildren().add(botonPlay);
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setPrefHeight(screenBounds.getHeight() * 0.2);
        super.setPrefWidth(screenBounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);
        super.setPadding(new Insets(screenBounds.getHeight() * 0.05, 0, 0, screenBounds.getWidth() * 0.031));
        algoblocks.addPropertyChangeListenerAlAlgoritmo(this.controladorAlgoritmo);
    }
}
