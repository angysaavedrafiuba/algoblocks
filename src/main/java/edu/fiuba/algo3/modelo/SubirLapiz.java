package edu.fiuba.algo3.modelo;

public class SubirLapiz extends Bloque {
    SubirLapiz() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.levantarLapiz();
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new BajarLapiz();
    }
    
}
