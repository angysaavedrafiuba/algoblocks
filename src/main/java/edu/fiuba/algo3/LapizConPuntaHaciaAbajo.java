package edu.fiuba.algo3;

public class LapizConPuntaHaciaAbajo implements Lapiz {

    @Override
    public boolean LapizArriba(){
        return false;
    }

    @Override
    public void dibujar(Dibujo dibujo, Posicion2D posicionADibujar) {
        dibujo.dibujar(posicionADibujar);
    }
}

