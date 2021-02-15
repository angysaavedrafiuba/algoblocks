package edu.fiuba.algo3;

public class MoverHaciaAbajo implements Bloque {
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_ABAJO, Posicion2D.Y_ABAJO), dibujo);
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }
}
