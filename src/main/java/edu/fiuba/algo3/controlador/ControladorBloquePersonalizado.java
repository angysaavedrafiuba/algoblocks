package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverHaciaArriba;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;


public class ControladorBloquePersonalizado extends SonidoClickBloque implements EventHandler {
    final RecorridoNormal recorrido;
    final BloqueAgregable bloque;

    public ControladorBloquePersonalizado(RecorridoNormal recorrido, BloqueAgregable bloque) {
        this.recorrido = recorrido;
        this.bloque = bloque;
    }

    @Override
    public void handle(Event event) {
        recorrido.agregarBloque(bloque.clonar());
        this.iniciarSonido();
    }
}
