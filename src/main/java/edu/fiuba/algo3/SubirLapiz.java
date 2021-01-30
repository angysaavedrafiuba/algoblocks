package edu.fiuba.algo3;

public class SubirLapiz implements Bloque{

    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.setLapiz(new LapizConPuntaHaciaArriba());
    }
}
