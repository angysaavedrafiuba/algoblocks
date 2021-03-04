package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BajarLapiz;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;

public class ControladorBloqueBajar  extends SonidoClickBloque implements EventHandler {
    @Override
    public void handle(Event event) {
        this.iniciarSonido();
        Algoblocks.getInstance().agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
    }
}