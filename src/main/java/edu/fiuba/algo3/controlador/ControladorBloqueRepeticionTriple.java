package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloqueDeRepeticion;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueRepeticionTriple extends SonidoClickBloque implements EventHandler {
    final RecorridoNormal recorrido;

    public ControladorBloqueRepeticionTriple(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueAgregable(new BloqueDeRepeticion(3)));
    }
}
