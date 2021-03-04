package edu.fiuba.algo3.controlador;
import javafx.scene.media.AudioClip;
import java.io.File;

public class SonidoClickBloque {
    private AudioClip sonido;

    public SonidoClickBloque() {
        this.sonido = new AudioClip(new File("src/main/resources/select.wav").toURI().toString());

    }
    public void iniciarSonido(){
        this.sonido.play(0.5);
    }
}
