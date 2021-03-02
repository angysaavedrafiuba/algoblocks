package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPlayHandler;
import edu.fiuba.algo3.controlador.BotonReiniciarHandler;
import edu.fiuba.algo3.listeners.ControladorAlgoritmo;
import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.servicios.ServicioImagenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class PanelAlgoritmo extends HBox {

    Scene scene;
    ControladorAlgoritmo controladorAlgoritmo = new ControladorAlgoritmo(this);
    Algoblocks algoblocks = Algoblocks.getInstance();
    private final Rectangle2D bounds;


    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene, Algoblocks algoblocks){
        super();
        this.scene = scene;
        this.bounds = screenBounds;
        BotonPlay botonPlay = new BotonPlay(screenBounds, scene);
        BotonTacho botonReiniciar = new BotonTacho(screenBounds, scene);

        super.getChildren().addAll(botonPlay, botonReiniciar);
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setPrefHeight(screenBounds.getHeight() * 0.2);
        super.setPrefWidth(screenBounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);
        super.setPadding(new Insets(screenBounds.getHeight() * 0.05, 0, 0, screenBounds.getWidth() * 0.031));

        algoblocks.addPropertyChangeListenerAlAlgoritmo(this.controladorAlgoritmo);
    }

    public void update(ArrayList<Bloque> bloques) {
        ArrayList<String> bloquesAAgregar = new ArrayList<String>();
        bloques.forEach(bloque -> bloquesAAgregar.add(ServicioImagenes.getInstance().imagenCorrespondienteA(bloque)));
        super.getChildren().clear();

        super.getChildren().add(new BotonPlay(this.bounds, this.scene));
        super.getChildren().add(new BotonTacho(this.bounds, this.scene));

        bloquesAAgregar.forEach(imagen -> super.getChildren().add(new ImagenConComportamiento(imagen, this.bounds, this.scene)));
    }
}
