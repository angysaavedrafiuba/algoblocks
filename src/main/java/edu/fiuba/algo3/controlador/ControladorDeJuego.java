package edu.fiuba.algo3.controlador;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class ControladorDeJuego {

    Scene scene;

    public ControladorDeJuego(){};

    public void init(Scene scene){
        this.scene = scene;
    }

    @FXML
    public void setPointer(Event e){
        this.scene.setCursor(Cursor.HAND);
    }

    @FXML
    public void setDefaultCursor(MouseEvent mouseEvent) {
        this.scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void logClick(MouseEvent e){
        System.out.println("Me han clickeado!!!");
    }
}
