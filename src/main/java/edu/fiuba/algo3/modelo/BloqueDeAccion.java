package edu.fiuba.algo3.modelo;

public class BloqueDeAccion extends Bloque{

    public BloqueDeAccion(Estado estadoDeBloque) {
        super();
        this.estado = estadoDeBloque;
    }

    @Override
    public Bloque clonar() {
        return new BloqueDeAccion(this.estado);
    }
}
