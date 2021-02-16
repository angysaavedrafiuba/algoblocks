package edu.fiuba.algo3;

public class BloqueNulo extends Bloque {
    BloqueNulo() {
        siguiente = null;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        try {
            this.siguiente.ejecutar(personaje, dibujo);
        }
        catch (RuntimeException e) { }
    }

    @Override
    public Bloque invertir() {
        return this;
    }

    @Override
    public Bloque invertirSecuencia() {
        Bloque nuevoSiguiente;
        try {
            nuevoSiguiente = this.siguiente.invertirSecuencia();
        }
        catch (RuntimeException e) {
            return this;
        }
        this.siguiente = nuevoSiguiente;
        return this;
    }
}
