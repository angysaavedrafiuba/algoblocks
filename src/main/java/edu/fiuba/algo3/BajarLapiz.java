package edu.fiuba.algo3;

public class BajarLapiz implements Bloque {
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.setLapiz(new LapizConPuntaHaciaAbajo());
        personaje.mover(new Posicion2D(0,0), dibujo);
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
