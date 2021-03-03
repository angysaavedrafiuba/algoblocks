package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueInversion implements EventHandler {
    @Override
    public void handle(Event event) {
        Algoblocks.getInstance().agregarBloqueAgregable(new BloqueAgregable(new InvertirComportamiento()));
    }
}
