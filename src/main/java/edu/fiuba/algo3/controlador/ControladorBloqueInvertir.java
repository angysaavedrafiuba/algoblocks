package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueInvertir extends SonidoClickBloque implements EventHandler {
    final RecorridoNormal recorrido;

    public ControladorBloqueInvertir(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueAgregable(new InvertirComportamiento()));
    }
}