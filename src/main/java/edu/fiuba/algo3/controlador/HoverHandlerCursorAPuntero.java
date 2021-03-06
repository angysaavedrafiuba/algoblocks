package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;

public class HoverHandlerCursorAPuntero implements EventHandler {

    final Scene scene;

    public HoverHandlerCursorAPuntero(Scene scene){
        this.scene = scene;
    }

    @Override
    public void handle(Event event) {
        this.scene.setCursor(Cursor.HAND);
    }
}
