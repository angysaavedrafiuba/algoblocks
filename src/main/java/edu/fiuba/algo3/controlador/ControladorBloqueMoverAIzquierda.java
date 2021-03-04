package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverALaIzquierda;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueMoverAIzquierda extends SonidoClickBloque implements EventHandler{
    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        Algoblocks.getInstance().agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
    }
}
