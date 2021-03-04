package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorBloqueCompuesto extends HBox {
    VBox vBox1;
    VBox vBox2;

    public ContenedorBloqueCompuesto(Scene scene, Rectangle2D bounds, BloqueAgregable bloque){
        super();
        super.setPrefWidth(bounds.getWidth());
        super.setPrefHeight(bounds.getHeight());

        vBox1 = new VBox();
        vBox2 = new VBox();

        vBox1.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        vBox2.setStyle("-fx-background-color: " + Colores.NARANJA + ";");

        vBox1.setPrefWidth(bounds.getWidth() * 0.5);
        vBox1.setPrefHeight(bounds.getHeight() * 2);
        vBox1.setAlignment(Pos.TOP_RIGHT);

        vBox2.setPrefWidth(bounds.getWidth() * 0.5);
        vBox2.setPrefHeight(bounds.getHeight() * 3);
        vBox1.setAlignment(Pos.TOP_CENTER);

        ScrollPane red = new ScrollPane(vBox1);
        ScrollPane black = new ScrollPane(vBox2);

        vBox1.setAlignment(Pos.TOP_CENTER);
        vBox1.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.17));
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setPadding(new Insets(bounds.getHeight() * 0.1, 0, 0, bounds.getWidth()*0.17));

        AgregadorBloques.agregarBloques(vBox1, new Rectangle2D(0, 0, 1500, 1000), scene, bloque.getRecorrido());

        super.getChildren().add(red);
        super.getChildren().add(black);
    }

    public void agregarBloque(ImagenBloqueEnAlgoritmo imagenBloque) {
        vBox2.getChildren().add(imagenBloque);
    }
}
