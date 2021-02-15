package edu.fiuba.algo3;

public class BloqueNulo implements Bloque {

    private Bloque siguiente;

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {

    }

    @Override
    public void siguiente(Bloque bloque) {
        throw new RuntimeException("No se puede agregar un bloque al nulo");
    }
}
