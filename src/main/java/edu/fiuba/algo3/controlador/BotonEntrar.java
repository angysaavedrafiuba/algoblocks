package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class BotonEntrar implements EventHandler<ActionEvent> {
    Stage stage;
    Scene otraEscena;
    AudioClip clip;

    public BotonEntrar(Stage stage, Scene escena, AudioClip audio){
        this.stage = stage;
        this.otraEscena = escena;
        this.clip = audio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        clip.stop();
        stage.setScene(otraEscena);
    }
}
