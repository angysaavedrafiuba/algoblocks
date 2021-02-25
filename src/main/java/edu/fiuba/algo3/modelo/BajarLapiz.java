package edu.fiuba.algo3.modelo;

public class BajarLapiz implements EstadoDeBloque {
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.apoyarLapiz();
        personaje.mover(new Posicion2D(0,0), dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return new SubirLapiz();
    }
}
