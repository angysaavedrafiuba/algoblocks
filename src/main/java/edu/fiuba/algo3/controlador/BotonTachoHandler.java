package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonTachoHandler implements EventHandler {


    private final RecorridoNormal algoritmo;

    public BotonTachoHandler(BloqueAgregable bloqueAgregable){
        this.algoritmo = bloqueAgregable.getRecorrido();
    }

    public BotonTachoHandler(){
        algoritmo = null;
    }

    @Override
    public void handle(Event event) {
        AudioClip clip = new AudioClip(new File("src/main/resources/tacho.wav").toURI().toString());
        clip.play(0.5);
        if (algoritmo == null) {
            Algoblocks.getInstance().reiniciarAlgoritmo();
            return;
        }

        algoritmo.reiniciar();
    }
}
