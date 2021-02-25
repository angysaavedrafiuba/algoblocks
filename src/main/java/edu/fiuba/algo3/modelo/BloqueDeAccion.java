package edu.fiuba.algo3.modelo;

public class BloqueDeAccion extends Bloque{

    BloqueDeAccion(EstadoDeBloque estadoDeBloque){
        this.estado = estadoDeBloque;
    }

    @Override
    public Bloque clonar() {
        return new BloqueDeAccion(this.estado);
    }
}
