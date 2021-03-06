package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

//TODO agregar imagen para bloque doble/triple
public class AgregadorBloques {

    public static void agregarBloques(Pane pane, Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido) {
        pane.getChildren().add(new ImagenBloque("draw-north.png",   screenBounds, scene, new ControladorBloqueMoverHaciaArriba(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-south.png",   screenBounds, scene, new ControladorBloqueMoverHaciaAbajo(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-east.png",    screenBounds, scene, new ControladorBloqueMoverADerecha(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-west.png",    screenBounds, scene, new ControladorBloqueMoverAIzquierda(recorrido)));
        pane.getChildren().add(new ImagenBloque("bajar.png",        screenBounds, scene, new ControladorBloqueBajar(recorrido)));
        pane.getChildren().add(new ImagenBloque("subir.png",        screenBounds, scene, new ControladorBloqueSubir(recorrido)));
        pane.getChildren().add(new ImagenBloque("invertir.png",     screenBounds, scene, new ControladorBloqueInvertir(recorrido)));
        pane.getChildren().add(new ImagenBloque("repeticion-doble.png",   screenBounds, scene, new ControladorBloqueRepeticionDoble(recorrido)));
        pane.getChildren().add(new ImagenBloque("repeticion-triple.png",   screenBounds, scene, new ControladorBloqueRepeticionTriple(recorrido)));
    }
}
