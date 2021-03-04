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

    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene){
        super();
        super.setAlignment(Pos.TOP_LEFT);

        this.scene = scene;
        this.bounds = screenBounds;

        Botonera botonera = new Botonera(screenBounds, scene);

        this.vistaBloquesAgregados = new VistaBloquesAgregados(screenBounds, scene);

        super.getChildren().add(botonera);
        super.getChildren().add(this.vistaBloquesAgregados);

        this.initStyles();

        Algoblocks.getInstance().getRecorridoNormal().addPropertyChangeListener(this.controladorAlgoritmo);
    }

    private void initStyles() {
        super.setStyle("-fx-background-color: #fa9579;");
        super.setPrefHeight(this.bounds.getHeight() * 0.2);
        super.setPrefWidth(this.bounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);

    }

    public void update(ArrayList<Bloque> bloques) {
        ArrayList<String> bloquesAAgregar = new ArrayList<>();
        bloques.forEach(bloque -> bloquesAAgregar.add(MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque)));
        this.vistaBloquesAgregados.limpiar();

        this.vistaBloquesAgregados.update(bloquesAAgregar.size());

        bloquesAAgregar.forEach(imagen -> {
            ImagenBloqueEnAlgoritmo bloque = new ImagenBloqueEnAlgoritmo(imagen, this.bounds, this.scene);
            this.vistaBloquesAgregados.agregarBloque(bloque);
        });
    }
}
