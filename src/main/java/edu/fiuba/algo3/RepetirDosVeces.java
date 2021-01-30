package edu.fiuba.algo3;

import java.util.ArrayList;

public class RepetirDosVeces implements Bloque, Algoritmo {
    private final ArrayList<Bloque> secuencia = new ArrayList<>();

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        for(int i=0; i<2; i++) {
            for(Bloque bloque:secuencia) {
                bloque.ejecutar(personaje, tablero);
            }
        }
    }

    @Override
    public void agregarBloque(Bloque bloque) {
        secuencia.add(bloque);
    }
}
