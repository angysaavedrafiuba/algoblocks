package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorBloqueCompuesto extends HBox {

    public ContenedorBloqueCompuesto(Scene scene, Rectangle2D bounds, BloqueAgregable bloque){
        super();
        super.setPrefWidth(bounds.getWidth());
        super.setPrefHeight(bounds.getHeight());

        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();

        vBox1.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        vBox2.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        vBox1.setPrefWidth(bounds.getWidth() * 0.5);
        vBox1.setPrefHeight(bounds.getHeight() * 3);
        vBox1.setAlignment(Pos.TOP_RIGHT);

        vBox2.setPrefWidth(bounds.getWidth() * 0.5);
        vBox2.setPrefHeight(bounds.getHeight() * 3);
        vBox1.setAlignment(Pos.TOP_CENTER);

        ScrollPane red = new ScrollPane(vBox1);
        ScrollPane black = new ScrollPane(vBox2);

        AgregadorBloques.agregarBloques(vBox1, bounds, scene, bloque.getRecorrido());

        super.getChildren().add(red);
        super.getChildren().add(black);
        //super.getChildren().add(new PanelDeBloques(bounds, scene, bloque.getRecorrido()));
    }
}
