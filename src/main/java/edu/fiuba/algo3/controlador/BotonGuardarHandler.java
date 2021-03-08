package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.EstadoDeBloque;
import edu.fiuba.algo3.vista.AgregadorBloques;
import edu.fiuba.algo3.vista.MapeoDeBloques;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.Scanner;

public class BotonGuardarHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        // TODO agregar input? Para obtener el nombre del algoritmo
        // TODO evitar que se haga todo lo de abajo en caso de que Algoblocks esté vacío
        BloqueAgregable nuevoPersonalizado = Algoblocks.getInstance().guardarAlgoritmo("Hola");
        Algoblocks.getInstance().reiniciarAlgoritmo();
        MapeoDeBloques.getInstance().agregarBloquePersonalizado((BloqueAgregable) nuevoPersonalizado.clonar());
        AgregadorBloques.getInstance().agregarBloquePersonalizado(nuevoPersonalizado);
        Algoblocks.getInstance().agregarBloqueAgregable(nuevoPersonalizado);
    }
}
