package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AgregadorBloques {
    private static ArrayList<BloqueAgregable> bloquesPersonalizados = new ArrayList<>();
    private final ArrayList<String> nombreBloques = new ArrayList<>();
    private ArrayList<EventHandler> controladores = new ArrayList<>();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private AgregadorBloques(){
        nombreBloques.add("draw-north.png");
        nombreBloques.add("draw-south.png");
        nombreBloques.add("draw-east.png");
        nombreBloques.add("draw-west.png");
        nombreBloques.add("bajar.png");
        nombreBloques.add("subir.png");
        nombreBloques.add("invertir.png");
        nombreBloques.add("repeticion-doble.png");
        nombreBloques.add("repeticion-triple.png");
    }

    public void agregarBloques(Pane pane, Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido) {
        inicializarControladores(recorrido);

        for (int i = 0; i < nombreBloques.size(); i++){
            pane.getChildren().add(new ImagenBloque(nombreBloques.get(i), screenBounds, scene, controladores.get(i)));
        }

        bloquesPersonalizados.forEach(bloque -> pane.getChildren().add(new ImagenBloqueGuardado(bloque.toString(), screenBounds, scene, recorrido, bloque)));
    }

    private void inicializarControladores(RecorridoNormal recorrido) {
        controladores = new ArrayList<>();

        controladores.add(new ControladorBloqueMoverHaciaArriba(recorrido));
        controladores.add(new ControladorBloqueMoverHaciaAbajo(recorrido));
        controladores.add(new ControladorBloqueMoverADerecha(recorrido));
        controladores.add(new ControladorBloqueMoverAIzquierda(recorrido));
        controladores.add(new ControladorBloqueBajar(recorrido));
        controladores.add(new ControladorBloqueSubir(recorrido));
        controladores.add(new ControladorBloqueInvertir(recorrido));
        controladores.add(new ControladorBloqueRepeticionDoble(recorrido));
        controladores.add(new ControladorBloqueRepeticionTriple(recorrido));
    }

    private static final AgregadorBloques instance = new AgregadorBloques();

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

    public double getCantidadDeBloques() {
        return bloquesPersonalizados.size() + nombreBloques.size();
    }
}
