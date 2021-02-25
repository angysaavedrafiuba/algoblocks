package edu.fiuba.algo3.modelo;

public class SubirLapiz implements EstadoDeBloque {

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.levantarLapiz();
    }

    @Override
    public EstadoDeBloque invertir() {
        return new BajarLapiz();
    }
}
