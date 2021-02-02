package edu.fiuba.algo3;

public class BajarLapiz implements Bloque {
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.setLapiz(new LapizConPuntaHaciaAbajo());
        personaje.mover(new Posicion2D(0,0), tablero);
        siguienteBloque.ejecutar(personaje, tablero);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
