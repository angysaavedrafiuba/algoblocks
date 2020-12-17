package edu.fiuba.algo3;

public class BajarLapiz implements Bloque {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.setLapiz(new LapizConPuntaHaciaAbajo());
    }
}
