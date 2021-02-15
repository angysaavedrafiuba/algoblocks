package edu.fiuba.algo3;

public class SubirLapiz implements Bloque{

    private Bloque siguienteBloque = new BloqueNulo();

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        personaje.setLapiz(new LapizConPuntaHaciaArriba());
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
