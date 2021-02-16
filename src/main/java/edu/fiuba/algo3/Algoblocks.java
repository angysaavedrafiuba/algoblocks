package edu.fiuba.algo3;

import java.util.ArrayList;

public class Algoblocks {
    private final Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    private final Dibujo dibujo = new Dibujo();
    private final RecorridoNormal bloques = new RecorridoNormal();

    public void agregarBloque(Bloque bloque){
        bloques.agregarBloque(bloque);
    }

    public void ejecutar(){
        bloques.ejecutar(this.personaje, this.dibujo);
    }

    /* Test only */
    public ArrayList<Posicion2D> obtenerDibujo() {
        return this.dibujo.posicionesDibujadas();
    }
}
