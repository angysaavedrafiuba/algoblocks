package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Dibujo {
    private ArrayList<Posicion2D> posicionesDibujadas = new ArrayList<>();

    public void dibujar(Posicion2D posicionADibujar) {
        posicionesDibujadas.add(posicionADibujar.clonarPosicion());
    }

    public void dibujarConLapiz(Posicion2D posicionADibujar, Lapiz lapiz) {
        lapiz.dibujar(this, posicionADibujar);
    }

    public void reiniciar() {
        posicionesDibujadas = new ArrayList<>();
    }

    /* Test only */
    public boolean enBlanco() {
        return(posicionesDibujadas.isEmpty());
    }

    public boolean estaDibujada(Posicion2D posicionAVerificar) {
        return posicionesDibujadas.stream().anyMatch(pos -> pos.esLaMismaQue(posicionAVerificar));
    }

    public ArrayList<Posicion2D> posicionesDibujadas() {
        return posicionesDibujadas;
    }
}
