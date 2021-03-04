package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueRepeticion extends SonidoClickBloque implements EventHandler {
    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        Algoblocks.getInstance().agregarBloqueAgregable(new BloqueAgregable(new BloqueDeRepeticion(2)));
    }
}