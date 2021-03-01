package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BajarLapiz;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueBajar implements EventHandler {
    @Override
    public void handle(Event event) {
        Algoblocks.getInstance().agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
    }
}