package edu.fiuba.algo3;

import java.util.ArrayList;

public class Dibujo {

    private final ArrayList<Posicion2D> posicionesDibujadas = new ArrayList<Posicion2D>();

    public boolean enBlanco() {
        return(posicionesDibujadas.isEmpty());
    }

    public void dibujar(Posicion2D posicionADibujar) {
        posicionesDibujadas.add(posicionADibujar.clonarPosicion());
    }


    public boolean estaDibujada(Posicion2D posicionAVerificar) {
        return posicionesDibujadas.stream().anyMatch(posicion -> {
            return posicion.esLaMismaQue(posicionAVerificar);
        });
    }

    public void dibujarConLapiz(Posicion2D posicionADibujar, Lapiz lapiz) {
        lapiz.dibujar(this, posicionADibujar);
    }

    public ArrayList<Posicion2D> posicionesDibujadas() {
        return posicionesDibujadas;
    }
}
