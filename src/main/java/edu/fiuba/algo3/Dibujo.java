package edu.fiuba.algo3;

import java.util.ArrayList;

public class Dibujo {

    private final ArrayList<Posicion> posicionesDibujadas = new ArrayList<Posicion>(10);

    public boolean enBlanco() {
        return(posicionesDibujadas.isEmpty());
    }

    public void dibujar(Posicion2D posicionADibujar) {
        posicionesDibujadas.add(posicionADibujar);
    }


    public boolean estaDibujada(Posicion2D posicionAVerificar) {
        return posicionesDibujadas.stream().anyMatch(posicion -> {
            return posicion.esLaMismaQue(posicionAVerificar);
        });
    }

    public void dibujarConLapiz(Posicion2D posicionADibujar, Lapiz lapiz) {
        lapiz.dibujar(this, posicionADibujar);
    }
}
