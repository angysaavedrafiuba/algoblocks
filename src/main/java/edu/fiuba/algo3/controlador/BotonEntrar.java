package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

public class BotonEntrar implements EventHandler<ActionEvent> {
    Stage stage;
    Scene otraEscena;

    public BotonEntrar(Stage stage, Scene escena){
        this.stage = stage;
        this.otraEscena = escena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(otraEscena);
    }
}
