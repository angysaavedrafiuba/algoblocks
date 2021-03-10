package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEntrar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class ContenedorInicial extends VBox {

    Stage stage;

    public ContenedorInicial(Stage stage, Scene escena){
        this.stage = stage;
        Image imagen = new Image("algoblocks.png");
        BackgroundImage fondo = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0,1.0,true,true,false,false));
        this.setBackground(new Background(fondo));
        AudioClip clip = new AudioClip(new File("src/main/resources/Child's Nightmare.wav").toURI().toString());
        clip.setCycleCount(AudioClip.INDEFINITE);
        clip.play(1.0);
        this.setSpacing(20);
        this.prefHeight(400.0);
        this.prefWidth(600.0);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15));
        Image img = new Image("entrar.png");

        ImageView view = new ImageView(img);
        view.setPreserveRatio(true);
        view.setPickOnBounds(true);
        view.setFitHeight(150.0);
        view.setFitWidth(200.0);

        Button boton = new Button();
        boton.setTextFill(Color.RED);
        boton.setGraphic(view);

        BotonEntrar inicializarEvento = new BotonEntrar(stage,escena, clip);
        boton.setOnAction(inicializarEvento);

        this.getChildren().add(boton);
    }
}
