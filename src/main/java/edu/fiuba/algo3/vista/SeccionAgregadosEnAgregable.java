package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBloqueCompuesto;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class SeccionAgregadosEnAgregable extends Pane {

    VBox vBox;
    Scene scene;

    public SeccionAgregadosEnAgregable(Scene scene, Rectangle2D bounds, BloqueAgregable bloque) {

        this.vBox = new VBox();
        VBox contenedorPrincipal = new VBox();
        BotonTacho botonTacho = new BotonTacho(bounds, scene, bloque);

        this.scene = scene;

        super.setPrefWidth(bounds.getWidth() * 0.5);
        super.setPrefHeight(bounds.getHeight() * 3);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        this.vBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        this.vBox.setPrefHeight(bounds.getHeight());
        this.vBox.setAlignment(Pos.TOP_CENTER);
        this.vBox.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.17));
        this.vBox.setPrefWidth(bounds.getWidth() * 0.5);
        this.vBox.setPrefHeight(bounds.getHeight() * 3);

        Label descripcion = new Label();
        descripcion.setText("Bloques agregados");
        descripcion.setFont(new Font(30));
        descripcion.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.09));

        contenedorPrincipal.getChildren().addAll(descripcion, botonTacho, this.vBox);

        super.getChildren().add(contenedorPrincipal);
    }

    public void update(Bloque bloque) {
        if(bloque == null){
            this.vBox.getChildren().clear();
            return;
        }
        String imgBloqueAAgregar = MapeoDeBloques.getInstance().imagenCorrespondienteA(bloque);
        ImagenBloqueEnAlgoritmo img = new ImagenBloqueEnAlgoritmo(imgBloqueAAgregar, new Rectangle2D(0, 0, 1500, 1000), this.scene);
        if(bloque instanceof BloqueAgregable) {
            img.setOnAction(new ControladorBloqueCompuesto((BloqueAgregable) bloque));
        }
        this.vBox.getChildren().add(img);
    }
}
