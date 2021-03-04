package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverHaciaAbajo;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorBloqueMoverHaciaAbajo extends SonidoClickBloque implements EventHandler {
    RecorridoNormal recorrido;

    public ControladorBloqueMoverHaciaAbajo(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
    }
}
