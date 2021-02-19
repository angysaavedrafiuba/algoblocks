package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoblocks {
    private final Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    private final Dibujo dibujo = new Dibujo();
    private final RecorridoNormal bloques = new RecorridoNormal();

    public void agregarBloque(EstadoDeBloque estado){
        bloques.agregarBloque(new Bloque(estado));
    }

    public void ejecutar() {
        bloques.ejecutar(this.personaje, this.dibujo);
    }

    public void reiniciarAlgoritmo() {
        bloques.reiniciar();
    }

    public void removerUltimo() {
        bloques.removerUltimo();
    }

    public void reiniciarDibujo() {
        dibujo.reiniciar();
    }

    /* Test only */
    public ArrayList<Posicion2D> obtenerDibujo() {
        return this.dibujo.posicionesDibujadas();
    }
}
