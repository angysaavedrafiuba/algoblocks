package edu.fiuba.algo3;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class InvertirComportamiento implements Bloque, Algoritmo {
    private final ArrayList<Bloque> secuencia = new ArrayList<>();

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        List<Bloque> temp = secuencia.subList(0, secuencia.size());
        Collections.reverse(temp);
        temp.forEach(bloque -> bloque.ejecutar(personaje, tablero));
    }

    @Override
    public void agregarBloque(Bloque bloque) {
        secuencia.add(bloque);
    }
}
