package edu.fiuba.algo3;

public class subirLapiz implements Bloque{
    @Override
    public void ejecutar(Personaje personaje){
        personaje.setLapiz(new lapizConPuntaHaciaArriba());
    }
}
