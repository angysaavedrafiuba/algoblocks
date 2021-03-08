package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.vista.AgregadorBloques;
import edu.fiuba.algo3.vista.MapeoDeBloques;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonResetHandler implements EventHandler {
    @Override
    public void handle(Event event) {

        AudioClip clip = new AudioClip(new File("src/main/resources/undo.wav").toURI().toString());
        clip.play(0.5);
        Algoblocks.getInstance().reset();
        MapeoDeBloques.getInstance().limpiar();
        AgregadorBloques.getInstance().limpiar();
    }
}
