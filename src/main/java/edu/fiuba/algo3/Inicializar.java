package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Inicializar extends VBox {

    Stage stage;

    public Inicializar(Stage stage, Scene escena){
        this.stage = stage;

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15));

        Button boton = new Button();
        boton.setText("Entrar");

        Label label = new Label();
        label.setText("TP algoblocks");
        label.setTextFill(Color.RED);

        //BotonEntrar inicializarEvento = new BotonEntrar(stage,escena);
        //boton.setOnAction(inicializarEvento);

        this.getChildren().addAll(label, boton);
    }
}
