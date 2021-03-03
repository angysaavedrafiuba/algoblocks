package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.Bloque;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PanelAlgoritmo extends HBox {

    Scene scene;
    VistaAlgoritmo controladorAlgoritmo = new VistaAlgoritmo(this);
    private final Rectangle2D bounds;
    public VistaBloquesAgregados vistaBloquesAgregados;
    HBox hBox;

    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene){
        super();
        this.scene = scene;
        this.bounds = screenBounds;

        Botonera botonera = new Botonera(screenBounds, scene);
        /* TODO: moduralizar la creacion de la HBox y el Scroll Pane en otra clase
        Delegar ahí el comportamiento de agregar bloques y limpiar la hBox.
        Ya está creada VistaBloquesAgregados y las lineas necesarias comentadas acá abajo
        pero por alguna razón da error de NullPointer*/

        // this.vistaBloquesAgregados = new VistaBloquesAgregados(screenBounds, scene);

        hBox = new HBox();
        hBox.setStyle("-fx-background-color: #ff2e63;");
        ScrollPane scroll = new ScrollPane(hBox);

        super.getChildren().add(botonera);
        // super.getChildren().add(this.vistaBloquesAgregados);
        super.getChildren().add(scroll);

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
        ArrayList<String> bloquesAAgregar = new ArrayList<>();

        bloques.forEach(bloque -> bloquesAAgregar.add(MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque)));
        // this.vistaBloquesAgregados.limpiar();
        // bloquesAAgregar.forEach(imagen -> this.vistaBloquesAgregados.agregarBloque(new ImagenConComportamiento(imagen, this.bounds, this.scene)));
        this.hBox.getChildren().clear();
        bloquesAAgregar.forEach(imagen -> this.hBox.getChildren().add(new ImagenConComportamiento(imagen, this.bounds, this.scene)));
    }
}
