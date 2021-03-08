package edu.fiuba.algo3.modelo;

public interface EstadoDeBloqueCompuesto extends Estado {
    Bloque agregarBloque(Bloque bloque);

    void setBloques(RecorridoNormal bloques);

    EstadoDeBloqueCompuesto clonar();
}
