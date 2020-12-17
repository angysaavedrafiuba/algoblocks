package edu.fiuba.algo3;

public class SubirLapiz implements Bloque{

    public void ejecutar(Personaje personaje){
        personaje.setLapiz(new lapizConPuntaHaciaArriba());
    }
}
