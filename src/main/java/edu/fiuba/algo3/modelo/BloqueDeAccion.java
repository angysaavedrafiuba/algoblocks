package edu.fiuba.algo3.modelo;

public class BloqueDeAccion extends Bloque{
    public BloqueDeAccion(EstadoDeBloque estadoDeBloque){
        super();
        idParticular = super.getId();
        this.estado = estadoDeBloque;
    }

    @Override
    public Bloque clonar() {
        return new BloqueDeAccion(this.estado);
    }

    @Override
    public int getId() {
        return idParticular;
    }
}
