package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PanelAlgoritmo extends HBox {

    Scene scene;

    PanelAlgoritmo(Rectangle2D screenBounds, Scene scene){
        super();
        this.scene = scene;
        super.getChildren().add(new ImagenConComportamiento("play-button.png", screenBounds, this.scene));
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setPrefHeight(screenBounds.getHeight() * 0.2);
        super.setPrefWidth(screenBounds.getWidth());
        super.setAlignment(Pos.CENTER_LEFT);
        super.setPadding(new Insets(screenBounds.getHeight() * 0.05, 0, 0, screenBounds.getWidth() * 0.031));
    }
}
