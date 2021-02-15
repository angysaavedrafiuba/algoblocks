package edu.fiuba.algo3;

import java.util.ArrayList;

public class Algoblocks {
    private final Personaje personaje = new Personaje(new Posicion2D(0,0));
    private final Dibujo dibujo = new Dibujo();
    private final ColaDeInstrucciones bloques = new ColaDeInstrucciones(new RecorridoNormal());

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
