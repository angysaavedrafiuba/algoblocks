package edu.fiuba.algo3;

import java.util.ArrayList;

public class Dibujo {

    private final ArrayList<Posicion> posicionesDibujadas = new ArrayList<Posicion>();

    public boolean enBlanco() {
        return(posicionesDibujadas.isEmpty());
    }

    public void dibujar(Posicion2D posicionADibujar) {
        posicionesDibujadas.add(posicionADibujar);
        System.out.println(posicionADibujar);
    }


    public boolean estaDibujada(Posicion2D posicionAVerificar) {
        return posicionesDibujadas.stream().anyMatch(posicion -> {
            return posicion.esLaMismaQue(posicionAVerificar);
        });
    }

    public void dibujarConLapiz(Posicion2D posicionADibujar, Lapiz lapiz) {
        lapiz.dibujar(this, posicionADibujar);
    }

    public ArrayList<Posicion> posicionesDibujadas() {
        ArrayList <Posicion> posicionesADevolver = new ArrayList<Posicion>();
        return posicionesDibujadas;
    }
}
