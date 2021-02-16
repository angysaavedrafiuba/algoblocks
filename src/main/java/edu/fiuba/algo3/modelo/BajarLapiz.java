package edu.fiuba.algo3.modelo;

public class BajarLapiz extends Bloque {
    BajarLapiz() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.bajarLapiz();
        personaje.mover(new Posicion2D(0,0), dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public SubirLapiz invertir() {
        return new SubirLapiz();
    }
}
