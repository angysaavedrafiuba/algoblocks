package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueRepeticionDoble extends SonidoClickBloque implements EventHandler {
    RecorridoNormal recorrido;

    public ControladorBloqueRepeticionDoble(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueAgregable(new BloqueDeRepeticion(2)));
    }
}