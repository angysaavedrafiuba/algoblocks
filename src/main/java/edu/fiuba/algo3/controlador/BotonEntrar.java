package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class BotonEntrar implements EventHandler<ActionEvent> {
    final Stage stage;
    final Scene otraEscena;
    final AudioClip clip;

    public BotonEntrar(Stage stage, Scene escena, AudioClip audio){
        this.stage = stage;
        this.otraEscena = escena;
        this.clip = audio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        clip.stop();
        stage.setScene(otraEscena);
        stage.setFullScreen(true);
        stage.setResizable(false);
    }
}
