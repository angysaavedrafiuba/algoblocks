package edu.fiuba.algo3;

public class SubirLapiz extends Bloque {
    SubirLapiz() {
        siguiente = new BloqueNulo();
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.subirLapiz();
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new BajarLapiz();
    }
    
}
