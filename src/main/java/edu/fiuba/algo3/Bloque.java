package edu.fiuba.algo3;

public abstract class Bloque {
    protected Bloque siguiente;

    public Bloque invertirSecuencia() {
        Bloque nuevoSiguiente = this.siguiente.invertirSecuencia();
        Bloque invertido = this.invertir();
        invertido.siguiente(nuevoSiguiente);
        return invertido;
    }

    public void siguiente(Bloque bloque) {
        siguiente = bloque;
    }

    public abstract Bloque invertir();

    public abstract void ejecutar(Personaje personaje, Dibujo dibujo);
}
