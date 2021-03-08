package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelDeBloques extends HBox implements PropertyChangeListener {

    final Scene scene;
    VBox vBox;
    Rectangle2D screenBounds;
    RecorridoNormal recorrido;

    PanelDeBloques(Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido){
        super();

        this.scene = scene;
        this.screenBounds = screenBounds;
        this.recorrido = recorrido;

        this.vBox = inicializarVBox(screenBounds, recorrido);


       ScrollPane scrollPane = new ScrollPane(this.vBox);

        super.setPrefHeight(screenBounds.getHeight() * 2);
        super.setPrefWidth(screenBounds.getWidth() * 0.20);
        super.setAlignment(Pos.TOP_RIGHT);
        super.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        super.getChildren().add(scrollPane);
    }

    private VBox inicializarVBox(Rectangle2D screenBounds, RecorridoNormal recorrido){

        this.vBox = new VBox();

        this.vBox.setPrefWidth(screenBounds.getWidth() * 0.2);
        this.vBox.setPrefHeight(screenBounds.getHeight() * 1.3);
        this.vBox.setPadding(new Insets(20,0,0, screenBounds.getHeight() * 0.1));
        this.vBox.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        AgregadorBloques.getInstance().agregarBloques(this.vBox, screenBounds, scene, recorrido);
        AgregadorBloques.getInstance().agregarListener(this);

        return this.vBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.vBox.getChildren().clear();
        AgregadorBloques.getInstance().agregarBloques(this.vBox, screenBounds, scene, recorrido);
    }
}
