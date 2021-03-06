package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverALaIzquierda;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueMoverAIzquierda extends SonidoClickBloque implements EventHandler{
    final RecorridoNormal recorrido;

    public ControladorBloqueMoverAIzquierda(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
    }
}
