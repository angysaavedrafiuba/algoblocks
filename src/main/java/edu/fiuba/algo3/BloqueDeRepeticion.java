package edu.fiuba.algo3;

import java.util.ArrayList;

public class BloqueDeRepeticion implements Bloque{
    private ColaDeInstrucciones secuencia = new ColaDeInstrucciones(new RecorridoNormal());
    private int repeticiones;

    BloqueDeRepeticion(int repeticiones){
        this.repeticiones = repeticiones;
    }


    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        for(int i=0; i<repeticiones; i++) {
            secuencia.ejecutar(personaje, tablero);
        }
    }

    @Override
    public void siguiente(Bloque bloque){
        secuencia.agregarBloque(bloque);
    }
}
