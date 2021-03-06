package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class VistaBloquesAgregados extends Pane {
    private final Rectangle2D bounds;
    private final HBox hBox;

    public VistaBloquesAgregados(Rectangle2D screenBounds, Scene scene) {
        super();
        this.bounds = screenBounds;
        this.hBox = initHbox();
        ScrollPane scrollPane = new ScrollPane(this.hBox);
        scrollPane.setPrefWidth(bounds.getWidth() * 0.8);

        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        super.getChildren().add(scrollPane);
        super.setPrefWidth(bounds.getWidth() * 0.8);
        super.setHeight(bounds.getHeight() * 0.2);
    }

    private HBox initHbox() {
        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        hBox.setPrefHeight(this.bounds.getHeight() * 0.2);
        hBox.setPrefWidth(this.bounds.getWidth() * 0.8);
        hBox.setPadding(new Insets(bounds.getHeight() * 0.02, 0,0, bounds.getWidth() * 0.02));

        return hBox;
    }

    public void agregarBloque(ImagenConComportamiento img) {
        this.hBox.getChildren().add(img);
    }

    public void limpiar() {
        this.hBox.getChildren().clear();
    }

    public void update(double size) {
        double extraSize = size - 7;

        if(extraSize < 1) {
            this.hBox.setPrefWidth(bounds.getWidth() * 0.8);
            return;
        }

        this.hBox.setPrefWidth(bounds.getWidth() * (0.9 + extraSize/5) );
    }
}
