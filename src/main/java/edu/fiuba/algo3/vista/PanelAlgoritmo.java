package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBloqueCompuesto;
import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class PanelAlgoritmo extends HBox {

    final Scene scene;
    final VistaAlgoritmo controladorAlgoritmo = new VistaAlgoritmo(this);
    private final Rectangle2D bounds;
    public final VistaBloquesAgregados vistaBloquesAgregados;
    private int cantidadDeBloquesAgregados;

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
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        super.setPrefHeight(this.bounds.getHeight() * 0.2);
        super.setPrefWidth(this.bounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);

    }

    public void update(Bloque bloque) {
        if(bloque == null) {
            this.vistaBloquesAgregados.limpiar();
            this.cantidadDeBloquesAgregados = 0;
            return;
        }

        this.cantidadDeBloquesAgregados++;

        String imgBloqueAAgregar = MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque);
        this.vistaBloquesAgregados.update(this.cantidadDeBloquesAgregados);

        if(bloque instanceof BloqueAgregable) {
            if(bloque.getEstado() instanceof BloquePersonalizado) {
                ImagenBloqueGuardado imagenBloqueGuardado;
                imagenBloqueGuardado = new ImagenBloqueGuardado(((BloquePersonalizado) bloque.getEstado()).getNombre(),
                                            this.bounds, this.scene);
                this.vistaBloquesAgregados.agregarBloque(imagenBloqueGuardado);
            } else {
                ImagenBloqueEnAlgoritmo imagenBloque = new ImagenBloqueEnAlgoritmo(imgBloqueAAgregar,
                                            this.bounds, this.scene);
                imagenBloque.setOnAction(new ControladorBloqueCompuesto((BloqueAgregable) bloque));
                this.vistaBloquesAgregados.agregarBloque(imagenBloque);
            }
        } else {
            ImagenBloqueEnAlgoritmo imagenBloque = new ImagenBloqueEnAlgoritmo(imgBloqueAAgregar, this.bounds, this.scene);
            this.vistaBloquesAgregados.agregarBloque(imagenBloque);
        }
    }
}
