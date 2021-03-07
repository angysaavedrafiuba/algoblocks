package edu.fiuba.algo3.modelo;

public interface EstadoDeBloqueCompuesto {
    Bloque agregarBloque(Bloque bloque);

    void setBloques(RecorridoNormal bloques);

    void ejecutar(Personaje personaje, Dibujo dibujo);

    EstadoDeBloqueCompuesto clonar();
}
