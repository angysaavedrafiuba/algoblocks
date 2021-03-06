package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonPlayHandler implements EventHandler<MouseEvent> {


    private final Algoblocks algoblocks;

    public BotonPlayHandler(){
        this.algoblocks = Algoblocks.getInstance();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        AudioClip clip = new AudioClip(new File("src/main/resources/play.wav").toURI().toString());
        clip.play(1.0);
        this.algoblocks.ejecutar();
    }
}
