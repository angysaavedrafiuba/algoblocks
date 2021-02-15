package edu.fiuba.algo3;

public class MoverALaIzquierda implements Bloque {
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_IZQUIERDA, Posicion2D.Y_IZQUIERDA), dibujo);
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
