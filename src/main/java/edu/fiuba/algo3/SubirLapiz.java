package edu.fiuba.algo3;

public class SubirLapiz implements Bloque{

    private Bloque siguienteBloque = new BloqueNulo();

    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.setLapiz(new LapizConPuntaHaciaArriba());
        siguienteBloque.ejecutar(personaje, tablero);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
