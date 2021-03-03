package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.Bloque;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PanelAlgoritmo extends HBox {

    Scene scene;
    VistaAlgoritmo controladorAlgoritmo = new VistaAlgoritmo(this);
    private final Rectangle2D bounds;


    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene){
        super();
        this.scene = scene;
        this.bounds = screenBounds;

        Botonera botonera = new Botonera(screenBounds, scene);

        super.getChildren().add(botonera);

        this.initStyles();

        Algoblocks.getInstance().getRecorridoNormal().addPropertyChangeListener(this.controladorAlgoritmo);
    }

    private void initStyles() {
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setPrefHeight(this.bounds.getHeight() * 0.2);
        super.setPrefWidth(this.bounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);
        super.setPadding(new Insets(this.bounds.getHeight() * 0.05, 0, 0, this.bounds.getWidth() * 0.031));
    }

    public void update(ArrayList<Bloque> bloques) {
        ArrayList<String> bloquesAAgregar = new ArrayList<String>();
        bloques.forEach(bloque -> bloquesAAgregar.add(MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque)));
        super.getChildren().clear();

        super.getChildren().add(new Botonera(this.bounds, this.scene));

        bloquesAAgregar.forEach(imagen -> super.getChildren().add(new ImagenConComportamiento(imagen, this.bounds, this.scene)));
    }
}
