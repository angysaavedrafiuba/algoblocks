package edu.fiuba.algo3;

public class MoverALaDerecha implements Bloque {
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_DERECHA, Posicion2D.Y_DERECHA), dibujo);
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }



}