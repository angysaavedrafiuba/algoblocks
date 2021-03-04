package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverHaciaArriba;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;



public class ControladorBloqueMoverHaciaArriba extends SonidoClickBloque implements EventHandler{
    RecorridoNormal recorrido;

    public ControladorBloqueMoverHaciaArriba(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        recorrido.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        this.iniciarSonido();
    }
}