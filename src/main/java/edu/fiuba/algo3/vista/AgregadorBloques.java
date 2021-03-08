package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AgregadorBloques {
    private static ArrayList<BloqueAgregable> bloquesPersonalizados = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void agregarBloques(Pane pane, Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido) {
        pane.getChildren().add(new ImagenBloque("draw-north.png",   screenBounds, scene, new ControladorBloqueMoverHaciaArriba(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-south.png",   screenBounds, scene, new ControladorBloqueMoverHaciaAbajo(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-east.png",    screenBounds, scene, new ControladorBloqueMoverADerecha(recorrido)));
        pane.getChildren().add(new ImagenBloque("draw-west.png",    screenBounds, scene, new ControladorBloqueMoverAIzquierda(recorrido)));
        pane.getChildren().add(new ImagenBloque("bajar.png",        screenBounds, scene, new ControladorBloqueBajar(recorrido)));
        pane.getChildren().add(new ImagenBloque("subir.png",        screenBounds, scene, new ControladorBloqueSubir(recorrido)));
        pane.getChildren().add(new ImagenBloque("invertir.png",     screenBounds, scene, new ControladorBloqueInvertir(recorrido)));
        pane.getChildren().add(new ImagenBloque("repeticion-doble.png",   screenBounds, scene, new ControladorBloqueRepeticionDoble(recorrido)));
        pane.getChildren().add(new ImagenBloque("repeticion-triple.png",   screenBounds, scene, new ControladorBloqueRepeticionTriple(recorrido)));

        bloquesPersonalizados.forEach(bloque -> pane.getChildren().add(new ImagenBloqueGuardado(bloque.toString(), screenBounds, scene, recorrido, bloque)));
    }

    private static AgregadorBloques instance = new AgregadorBloques();

    public static AgregadorBloques getInstance() {
        return instance;
    }

    public void agregarBloquePersonalizado(BloqueAgregable bloque) {
        bloquesPersonalizados.add(bloque);
        support.firePropertyChange("bloquesPersonalizados", null, bloquesPersonalizados);
    }

    public void agregarListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void limpiar() {
        bloquesPersonalizados = new ArrayList<>();
        support.firePropertyChange("bloquesPersonalizados", null, bloquesPersonalizados);
    }
}
