package edu.fiuba.algo3.modelo;

public abstract class Bloque {
    protected Bloque siguiente;

    public Bloque invertirSecuencia() {
        Bloque nuevoSiguiente = this.siguiente.invertirSecuencia();
        Bloque invertido = this.invertir();
        invertido.siguiente(nuevoSiguiente);
        return invertido;
    }

    public void siguiente(Bloque bloque) {
        this.siguiente = bloque;
    }

    public abstract Bloque invertir();

    public abstract void ejecutar(Personaje personaje, Dibujo dibujo);

    public Bloque removerUltimo(Bloque anterior) {
        try {
            return siguiente.removerUltimo(this);
        } catch (RuntimeException e) {
            anterior.siguiente = new BloqueNulo();
            return anterior;
        }
    }
}
