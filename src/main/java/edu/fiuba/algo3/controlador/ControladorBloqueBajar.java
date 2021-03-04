package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BajarLapiz;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;

public class ControladorBloqueBajar  extends SonidoClickBloque implements EventHandler {
    RecorridoNormal recorrido;

    public ControladorBloqueBajar(RecorridoNormal recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        recorrido.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
    }
}