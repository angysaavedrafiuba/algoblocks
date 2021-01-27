package edu.fiuba.algo3;

import java.util.List;

public class Tablero {
    private final Personaje personaje = new Personaje(new Posicion2D(0,0));
    private final Dibujo dibujo = new Dibujo();
    public boolean lapizArriba() {
        return personaje.lapizEstaArriba();
    }

    public void ejecutarAlgoritmo(List<Bloque> bloques) {
        for(Bloque bloque:bloques) {
            bloque.ejecutar(personaje);
        }
    }

}
