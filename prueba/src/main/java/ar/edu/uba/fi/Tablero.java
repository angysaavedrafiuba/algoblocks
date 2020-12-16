package ar.edu.uba.fi;

public class Tablero {
    private final Personaje personaje = new Personaje();
    private final Coordenada posicion = new Coordenada();

    public Personaje obtenerPersonaje(){
        return personaje;
    }

    public boolean lapizArriba() {
        return personaje.lapizEstaArriba();
    }

    /*public void moverPersonaje(Bloque bloque) {
        posicion.calcularNuevaPosicion(bloque);
    }*/
}
