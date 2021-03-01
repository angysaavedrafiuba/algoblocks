package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;

public class HoverHandlerCursorADefault implements EventHandler {

    Scene scene;

    public HoverHandlerCursorADefault(Scene scene){
        this.scene = scene;
    }

    @Override
    public void handle(Event event) {
        this.scene.setCursor(Cursor.DEFAULT);
    }

}
