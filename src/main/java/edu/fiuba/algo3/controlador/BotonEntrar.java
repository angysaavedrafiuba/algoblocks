package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BotonEntrar implements Initializable {
    Stage stage;
    Scene otraEscena;

    public BotonEntrar(){ }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void cambiarEscena(){
        this.stage.setScene(this.otraEscena);
        this.stage.setFullScreen(true);
        this.stage.setResizable(false);
    }

    @FXML
    public void init(Stage stage, Scene scene){
        this.stage = stage;
        this.otraEscena = scene;
    }
}
