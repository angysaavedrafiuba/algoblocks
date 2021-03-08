package edu.fiuba.algo3.modelo;

public interface EstadoDeBloqueCompuesto extends Estado {

    void setBloques(RecorridoNormal bloques);

    EstadoDeBloqueCompuesto clonar();
}
