package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private final Personaje personaje = new Personaje(new Posicion2D(0,0));
    private final Dibujo dibujo = new Dibujo();

    public void ejecutarAlgoritmo(ColaDeInstrucciones colaDeInstrucciones) {
        colaDeInstrucciones.ejecutar(this.personaje, this);
    }

    // REVISAR!! Es la parte que más ruido hace del modelo
    public void dibujarEnConLapiz(Posicion2D posicion, Lapiz lapiz) {
        this.dibujo.dibujarConLapiz(posicion, lapiz);
    }

    //Test only
    public ArrayList<Posicion2D> obtenerDibujo() {
        return dibujo.posicionesDibujadas();
    }
}
