package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBloqueCompuesto;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class SeccionAgregadosEnAgregable extends Pane {

    final VBox contenedorBloques;
    final Scene scene;

    public SeccionAgregadosEnAgregable(Scene scene, Rectangle2D bounds, BloqueAgregable bloque) {

        this.contenedorBloques = inicializarContenedorBloques(bounds);
        VBox contenedorPrincipal = new VBox();
        VBox contenedorBoton = new VBox();
        contenedorBoton.setPadding(new Insets(bounds.getHeight() *0.1, 0,0, bounds.getWidth() * 0.2));

        BotonTacho botonTacho = new BotonTacho(bounds, scene, bloque);


        this.scene = scene;

        super.setPrefWidth(bounds.getWidth() * 0.5);
        super.setPrefHeight(bounds.getHeight() * 3);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        Label descripcion = inicializarLabel(bounds);

        contenedorBoton.getChildren().add(botonTacho);
        contenedorPrincipal.getChildren().addAll(descripcion, contenedorBoton, this.contenedorBloques);

        super.getChildren().add(contenedorPrincipal);
    }

    private Label inicializarLabel(Rectangle2D bounds) {
        Label descripcion = new Label();
        descripcion.setText("Bloques agregados");
        descripcion.setFont(new Font(30));
        descripcion.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.09));

        return descripcion;
    }

    private VBox inicializarContenedorBloques(Rectangle2D bounds) {
        VBox contenedor = new VBox();

        contenedor.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        contenedor.setPrefHeight(bounds.getHeight());
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setPadding(new Insets(bounds.getHeight() * 0.03, 0, 0, bounds.getWidth() * 0.12));
        contenedor.setPrefWidth(bounds.getWidth() * 0.5);
        contenedor.setPrefHeight(bounds.getHeight() * 3);

        return contenedor;
    }

    public void update(Bloque bloque) {
        if(bloque == null){
            this.contenedorBloques.getChildren().clear();
            return;
        }
        String imgBloqueAAgregar = MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque);
        ImagenBloqueEnAlgoritmo img = new ImagenBloqueEnAlgoritmo(imgBloqueAAgregar, new Rectangle2D(0, 0, 1500, 1000), this.scene);

        if(bloque instanceof BloqueAgregable) {
            if(bloque.getEstado() instanceof BloquePersonalizado) {
                ImagenBloqueGuardado imagenBloqueGuardado = new ImagenBloqueGuardado(((BloquePersonalizado) bloque.getEstado()).getNombre(),
                        new Rectangle2D(0, 0, 1500, 1000), this.scene);
                this.contenedorBloques.getChildren().add(imagenBloqueGuardado);
                return;
            } else {
                img.setOnAction(new ControladorBloqueCompuesto((BloqueAgregable) bloque));
            }
        }
        this.contenedorBloques.getChildren().add(img);
    }
}
