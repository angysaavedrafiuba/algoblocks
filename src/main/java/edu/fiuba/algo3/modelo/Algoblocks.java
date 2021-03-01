package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.listeners.ControladorAlgoritmo;
import edu.fiuba.algo3.listeners.ControladorDibujo;
import edu.fiuba.algo3.listeners.ControladorPersonaje;

import java.util.ArrayList;

public class Algoblocks {
    private final Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    private final Dibujo dibujo = new Dibujo();
    private final RecorridoNormal bloques = new RecorridoNormal();

    private static Algoblocks instance;

    public static Algoblocks getInstance() {
        return instance;
    }

    public static void Create() {
        instance = new Algoblocks();
    }

    public void agregarBloqueDeAccion(BloqueDeAccion bloque){
        bloques.agregarBloque(bloque);
    }

    public void agregarBloqueAgregable(BloqueAgregable bloque){ bloques.agregarBloque(bloque); }

    public void ejecutar() {
        bloques.ejecutar(this.personaje, this.dibujo);
    }

    public void reiniciarAlgoritmo() {
        bloques.reiniciar();
    }

    public void removerUltimo() {
        bloques.removerUltimo();
    }

    public void reiniciarDibujo() {
        dibujo.reiniciar();
    }

    /* Test only */
    public ArrayList<Posicion2D> obtenerDibujo() {
        return this.dibujo.posicionesDibujadas();
    }

    public void addPropertyChangeListenerADibujo(ControladorDibujo controladorDibujo) {
        this.dibujo.addPropertyChangeListener(controladorDibujo);
    }

    public void addPropertyChangeListenerAlAlgoritmo(ControladorAlgoritmo controladorAlgoritmo) {
        this.bloques.addPropertyChangeListener(controladorAlgoritmo);
    }

    public void addPropertyChangeListenerAlPersonaje(ControladorPersonaje controladorPersonaje) {
        this.personaje.addPropertyChangeListener(controladorPersonaje);
    }
}
