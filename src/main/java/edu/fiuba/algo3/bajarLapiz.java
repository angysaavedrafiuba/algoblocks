package edu.fiuba.algo3;

public class bajarLapiz implements Bloque {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.setLapiz(new lapizConPuntaHaciaAbajo());
    }
}
